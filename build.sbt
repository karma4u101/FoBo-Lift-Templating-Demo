organization := "se.media4u101"

name := "FoBo-Lift-Template"

version := "2.6.0-SNAPSHOT"

crossScalaVersions := Seq("2.10.0", "2.9.2", "2.9.1-1", "2.9.1")

scalaVersion := "2.10.0"

seq(com.github.siasia.WebPlugin.webSettings :_*)

scalacOptions ++= Seq("-deprecation", "-unchecked")

scanDirectories in Compile := Nil

logLevel := Level.Info

resolvers ++= Seq(
  "Sonatype snapshots"             at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype releases"              at "http://oss.sonatype.org/content/repositories/releases",
  "Java.net Maven2 Repository"     at "http://download.java.net/maven/2/"
)

EclipseKeys.withSource := true

transitiveClassifiers := Seq("sources")//,"javadocs")

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT" // Put the current/latest lift version here
  Seq(
    "net.liftweb"     %% "lift-webkit"                        % liftVersion      % "compile" withSources(),
    "net.liftweb"     %% "lift-mapper"                        % liftVersion      % "compile",
    "net.liftweb"     %% "lift-squeryl-record"                % liftVersion      % "compile" withSources(),
    //"net.liftweb"     %% "lift-wizard"                        % liftVersion      % "compile",
    "net.liftweb"     %% "lift-testkit"                       % liftVersion      % "compile",
    "net.liftmodules" %% "fobo_2.5"                           % "0.9.7-SNAPSHOT" % "compile" withJavadoc() withSources()         
    )
}
//"net.liftmodules" %% "fobo"                             % (liftVersion+"-0.9.3-SNAPSHOT") withJavadoc() withSources() 

// Customize any further dependencies as desired
libraryDependencies <++= scalaVersion { sv =>
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "provided" ::
  "log4j" % "log4j" % "1.2.16" % "provided" ::
  "org.eclipse.jetty"        % "jetty-webapp"  % "8.0.3.v20111011" % "container" ::
  "org.eclipse.jetty"        % "jetty-plus"    % "8.0.3.v20111011" % "container" :: 
  "commons-lang"             % "commons-lang"  % "2.0"             % "compile->default" ::
  "com.jolbox"               % "bonecp"        % "0.7.1.RELEASE"   % "compile->default" ::
  "com.h2database"           % "h2"            % "1.3.167" ::  
  (sv match {
      case "2.10.0" | "2.9.2" | "2.9.1" | "2.9.1-1" => "org.specs2" %% "specs2" % "1.12.3" % "test"
      case _ => "org.specs2" %% "specs2" % "1.12.3" % "test"
      }) ::
   (sv match {
      case "2.10.0" | "2.9.2" => "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
      case _ => "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
      }) ::
  Nil
}




