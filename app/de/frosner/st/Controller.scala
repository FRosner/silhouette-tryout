package de.frosner.st

import javax.inject._
import play.api.mvc._

@Singleton
class Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("")
  }
}
