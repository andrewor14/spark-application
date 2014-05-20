name := "best-app-ever"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

resolvers += "Spark 1.0 RC" at "https://repository.apache.org/content/repositories/orgapachespark-1018"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.0.0"
