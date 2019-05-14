name := "SparkSqlProg"

version := "0.3"

scalaVersion := "2.11.8"

val sparkVersion = "2.3.0"

//libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"

//libraryDependencies ++= Seq(
  // Third-party libraries
  //"net.sf.jopt-simple" % "jopt-simple" % "4.3",
  //"joda-time" % "joda-time" % "2.0"
//)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "mysql" % "mysql-connector-java" % "5.1.6"
  //"org.slf4j" % "slf4j-simple" %  "1.6.6",
  //"com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
)

// This statement includes the assembly plug-in capabilities
//assemblySettings

// Configure JAR used with the assembly plug-in
//jarName in assembly := "my-project-assembly.jar"

// A special option to exclude Scala itself from our assembly JAR, since Spark
// already bundles Scala.
//assemblyOption in assembly :=
  //(assemblyOption in assembly).value.copy(includeScala = false)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}


