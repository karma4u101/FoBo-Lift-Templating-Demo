
organization := "se.media4u101"

name := "FoBo-Lift-Template"

version := "2.6-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

//run with ~container:start using a context path localhost:8080/test to make sure noting breaks 
//env in Compile :=  Some(file(".") / "jetty-env.xml" asFile) 
 
// If using JRebel
//jettyScanDirs := Nil
scanDirectories in Compile := Nil

logLevel := Level.Info
//Level.Info.Debug

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

EclipseKeys.withSource := true

transitiveClassifiers := Seq("sources")//,"javadocs")

libraryDependencies ++= {
  val liftVersion = "2.4" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default",
    "net.liftmodules" %% "fobo" % (liftVersion+"-0.4.2-SNAPSHOT") withJavadoc() withSources() 
    )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.3.v20111011" % "container",
  "org.eclipse.jetty" % "jetty-plus" % "8.0.3.v20111011" % "container", 
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "compile->default", // Logging
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
  "org.specs2" %% "specs2" % "1.6.1" % "test",
  "commons-lang" % "commons-lang" % "2.0" % "compile->default",
  "com.jolbox" % "bonecp" % "0.7.1.RELEASE" % "compile->default"  
)
