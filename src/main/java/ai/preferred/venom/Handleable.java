/*
 * Copyright 2018 Preferred.AI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.preferred.venom;

import ai.preferred.venom.job.Scheduler;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;

import javax.validation.constraints.NotNull;

/**
 * This interface represents the method call when the response is valid
 * the parsing logic will be up to individual implementations.
 *
 * @author Maksim Tkachenko
 * @author Ween Jiann Lee
 */
public interface Handleable {

  /**
   * This function is called when the request is fetched successfully.
   * <p>
   * This function will hold the logic after the page/file has been fetched.
   * </p>
   *
   * @param request   request fetched.
   * @param response  response received from server.
   * @param scheduler scheduler used for this request.
   * @param session   session variables defined when the crawler is initiated.
   * @param worker    provides the ability to run code in a separate thread.
   */
  void handle(@NotNull Request request, @NotNull Response response, @NotNull Scheduler scheduler,
              @NotNull Session session, @NotNull Worker worker);

}
