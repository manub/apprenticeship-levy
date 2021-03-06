/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.apprenticeshiplevy.controllers

import play.api.libs.json.Json
import play.api.mvc.Action
import uk.gov.hmrc.apprenticeshiplevy.data.LevyData
import uk.gov.hmrc.play.microservice.controller.BaseController

object LevyDeclarationController extends LevyDeclarationController

trait LevyDeclarationController extends BaseController {

  def declarations(empref: String, months: Option[Int]) = Action { implicit request =>
    LevyData.data.get(empref) match {
      case Some(ds) => Ok(Json.toJson(ds))
      case None => NotFound
    }
  }
}
