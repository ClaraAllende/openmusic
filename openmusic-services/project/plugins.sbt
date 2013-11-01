// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

//Embedded Mongo Repo
resolvers += "Embedded Mongo" at "http://repo1.maven.org/maven2/de/flapdoodle/embed/de.flapdoodle.embed.mongo/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.1")