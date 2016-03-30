package net.manub.akkatodobackend

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import org.slf4j.LoggerFactory

import scala.util.{Failure, Success}

object Main extends App {

  val log = LoggerFactory.getLogger(Main.getClass)

  implicit val system = ActorSystem("akka-todo-backend")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val ping = path("ping") {
    get {
      complete("pong!")
    }
  }

  Http().bindAndHandle(ping, "0.0.0.0", 8080).onComplete {
    case Success(binding) =>
      log.info(s"Running on ${binding.localAddress}")
    case Failure(ex) =>
      log.error(s"Failed to start", ex)
      system.terminate()
      System.exit(-1)
  }

}
