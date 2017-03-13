//libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.9",
  "org.specs2" %% "specs2-scalacheck" % "3.8.9",
  "org.typelevel" %% "discipline" % "0.7.3"
)
