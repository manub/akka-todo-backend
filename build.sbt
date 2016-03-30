organization := "net.manub"

name := "akka-todo-backend"

scalaVersion := "2.12.0-M3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.2",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.2",
  "ch.qos.logback" % "logback-classic" % "1.1.7"
)

mainClass := Some("net.manub.akkatodobackend.Main")
version := "0.0.1-SNAPSHOT"
maintainer := "Emanuele Blanco"

enablePlugins(JavaServerAppPackaging, DockerPlugin)

dockerExposedPorts := Seq(8080)
dockerRepository := Some("manub")

