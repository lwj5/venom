package ai.preferred.venom.response;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VResponseTest {

  @Test
  public void testVResponse() {
    final String path = "/test-response";
    final String headerKey = "Cookie";
    final String headerValue = "text=json;";
    final String url = "http://127.0.0.1/" + path;

    final int statusCode = 200;
    final String contentStr = "This is a test";
    final byte[] content = contentStr.getBytes();
    final ContentType contentType = ContentType.TEXT_PLAIN;
    final Header[] headers = {new BasicHeader(headerKey, headerValue)};
    final HttpHost proxy = new HttpHost("127.0.0.1", 80);

    final BaseResponse baseResponse = new BaseResponse(statusCode, url, content, contentType, headers, proxy);

    final VResponse vResponse = new VResponse(baseResponse);
    Assertions.assertEquals(statusCode, vResponse.getStatusCode());
    Assertions.assertEquals(content, vResponse.getContent());
    Assertions.assertEquals(contentType, vResponse.getContentType());
    Assertions.assertEquals(headers, vResponse.getHeaders());
    Assertions.assertEquals(url, vResponse.getBaseUrl());
    Assertions.assertEquals(proxy, vResponse.getProxy());
    Assertions.assertEquals(contentStr, vResponse.getHtml());
    Assertions.assertNotNull(vResponse.getJsoup());
    Assertions.assertNotNull(vResponse.getJsoup(VResponse.DEFAULT_CHARSET));
    Assertions.assertEquals(baseResponse, vResponse.getInner());
  }

}
