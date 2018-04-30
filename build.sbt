lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(
    name := "silhouette-tryout",
    startYear := Some(2018),
    description := "Just a small project to try out Silhouette",
    homepage := Some(url(s"https://github.com/FRosner/silhouette-tryout")),
    licenses += "Apache 2" -> url("https://www.apache.org/licenses/LICENSE-2.0"),
    // Release settings: Publish maven style, sign our releases, and define the release steps
    Defaults.itSettings,
    // Build settings of this project
    // Macro tooling (for simulacrum and others)
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    // A set of useful dependencies
    libraryDependencies ++= List(
      guice,
      // Basic data structures for funtional programming
      "org.typelevel" %% "cats-core" % "0.9.0",
      // Enum types,
      "com.beachape" %% "enumeratum" % "1.5.11",
      "com.beachape" %% "enumeratum-play-json" % "1.5.12",
      // Nicer syntax for type classes
      "com.github.mpilquist" %% "simulacrum" % "0.10.0",
      // Logging
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
      // Generic programming over data structures
      "com.chuusai" %% "shapeless" % "2.3.2",
      // Test framework
      "org.scalatest" %% "scalatest" % "3.0.1" % Test,
      // Property testing
      "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
      // Mocking
      "org.mockito" % "mockito-core" % "2.7.19" % Test,
      // Config
      "com.github.pureconfig" %% "pureconfig" % "0.8.0"
    ),
    // Build settings for all projects in this build
    inThisBuild(
      List(
        organization := "frosner",
        scmInfo := Some(ScmInfo(
          url("https://github.com/FRosner/silhouette-tryout"),
          "scm:git:https://github.com/FRosner/silhouette-tryout.git",
          Some(s"scm:git:git@github.com:FRosner/silhouette-tryout.git")
        )),
        // Scala versions we build for
        scalaVersion := "2.12.4",
        // Build settings
        scalacOptions ++= List(
          // Code encoding
          "-encoding",
          "UTF-8",
          // Deprecation warnings
          "-deprecation",
          // Warnings about features that should be imported explicitly
          "-feature",
          // Enable additional warnings about assumptions in the generated code
          "-unchecked",
          // Recommended additional warnings
          "-Xlint",
          // Warn when argument list is modified to match receiver
          "-Ywarn-adapted-args",
          // Warn about dead code
          "-Ywarn-dead-code",
          // Warn about inaccessible types in signatures
          "-Ywarn-inaccessible",
          // Warn when non-nullary overrides a nullary (def foo() over def foo)
          "-Ywarn-nullary-override",
          // Warn when numerics are unintentionally widened
          "-Ywarn-numeric-widen"
        )
      )
    )
  )
