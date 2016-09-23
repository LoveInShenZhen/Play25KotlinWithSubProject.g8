name := """$name;format="camel"$"""

lazy val commonSettings = Seq(
  javacOptions ++= Seq("-parameters", "-Xlint:unchecked", "-Xlint:deprecation", "-encoding", "UTF8"),
  scalacOptions ++= Seq("-encoding", "UTF8"),
  publishMavenStyle := true,
  organization := "love.in.shenzhen",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  kotlinVersion := "$KotlinVersion$",
  sources in(Compile, doc) := Seq.empty
)

lazy val k_base = (project in file("subProjects/$subProjectName$"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayJava, PlayEbean)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(PlayJava, PlayEbean)
  .aggregate(k_base)
  .dependsOn(k_base)

publishArtifact in(Compile, packageDoc) := false

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

kotlinLib("stdlib")
kotlinLib("reflect")
//kotlincOptions += "-verbose"

libraryDependencies += filters

libraryDependencies += "org.jodd" % "jodd-core" % "3.7"

libraryDependencies += "org.jodd" % "jodd-bean" % "3.7"

libraryDependencies += "org.jodd" % "jodd-http" % "3.7"

libraryDependencies += "org.jodd" % "jodd-mail" % "3.7"

libraryDependencies += "org.simpleframework" % "simple-xml" % "2.7.1"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.39"

