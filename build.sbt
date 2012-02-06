
organization := "nu.m4u"

name := "FoBo-Lift-Template"

version := "1.3-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

// If using JRebel
//jettyScanDirs := Nil
scanDirectories in Compile := Nil

logLevel := Level.Info
//Level.Debug

//resolvers += ScalaToolsSnapshots
resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
///*"Scala Tools Snapshot" at "http://scala-tools.org/repo-snapshots/",*/
///*"My Local Maven2 Repository" at "file://"+Path.userHome+"/.m2/repository/"*/

//resolvers ++= Seq(
//  "Scala Tools" at "http://scala-tools.org/repo-releases/",
//  ScalaToolsSnapshots,
//  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
//)

EclipseKeys.withSource := true

transitiveClassifiers := Seq("sources")

libraryDependencies ++= {
  val liftVersion = "2.4" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default",
    "net.liftmodules" %% "fobo" % (liftVersion+"-0.2.4-SNAPSHOT")
    )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.3.v20111011" % "container",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "org.mindrot" % "jbcrypt" % "0.3m" % "compile->default",  
  "com.h2database" % "h2" % "1.2.138", // In-process database, useful for development systems
  "mysql" % "mysql-connector-java" % "5.1.17", //Used in dev-test-jetty-run i.e for development systems outside of jni context
  "postgresql" % "postgresql" % "9.0-801.jdbc4", //Used in dev-test-jetty-run i.e for development systems outside of jni context
  "com.jolbox" % "bonecp" % "0.7.1.RELEASE" % "compile->default",
  "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "compile->default", // Logging
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
  "org.specs2" %% "specs2" % "1.6.1" % "test",
  "commons-lang" % "commons-lang" % "2.0" % "compile->default"
)
