import java.io.File

import org.apache.hadoop.hive.metastore.api.{MetaException, NoSuchObjectException}
import org.apache.spark.sql.SparkSession
//import org.apache.hadoop.hive.ql.exec.spark.session.SparkSession
import org.apache.hadoop.hive.ql.metadata.HiveException
//import org.apache.hadoop.hive.ql.parse.ParseException
import org.apache.log4j.Logger
import org.apache.spark.sql.catalyst.parser.ParseException
import org.apache.spark.sql.execution.QueryExecutionException

import scala.io.Source

//import sun.util.logging.resources.logging-logging

//import com.sun.tools.javac.code.Source


  //import org.apache.spark.sql.Row
  // $example on:init_session$
  //import org.apache.spark.sql.SparkSession
  // $example off:init_session$
  // $example on:programmatic_schema$
  // $example on:data_types$
  //import org.apache.spark.sql.types._
  // $example off:data_types$
  // $example off:programmatic_schema$

 object SparkSqlUpdater {

    def main(args: Array[String]): Unit = {
      println("Hello World!")
      if (args.length == 0) {
        println("dude, Please give file filename as one parameter")
      }
      val filename = args(0)
      //val filename = "fileopen.scala"

      val log = Logger.getLogger(getClass.getName)


      val warehouseLocation = new File("spark-warehouse").getAbsolutePath

      val spark = SparkSession
        .builder()
        .appName("Spark hercules to herculessub sync job")
        .config("spark.sql.warehouse.dir", warehouseLocation)
        .enableHiveSupport()
        .getOrCreate()



      //Lines into Arrays
//    val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toList
//    val lines = Source.fromFile("/Users/Al/.bash_profile").getLines.toArray

      //val bufferedSource = Source.fromFile("example.txt")

      //val theArrayYouWant = Source.fromFile(filename).getLines.mkString.split(";")
      println("""HELLOOOOOO: """ + sys.props("line.separator"))

      //val theArrayYouWant = Source.fromFile(filename).getLines.mkString.replaceAll("[\\r\\n]", "   ").split(";")
      val theArrayYouWant = Source.fromFile(filename).getLines.mkString(" ").split(";")




//      for (line <- Source.fromFile(filename).getLines) {
//        println(line)
//      }

      for (line <- theArrayYouWant) {
        println(line)

      }
      //val bufferedSource = Source.fromFile(filename)
      //val bufferedSource = Source.fromFile(filename).getLines.mkString

      //import spark.implicits._

      // define an accumulable collection for exceptions
      //val accumulable = sc.accumulableCollection(mutable.HashSet[(Any, Throwable)]())

      //for (line <- bufferedSource.getLines) {
        for (query <- theArrayYouWant) {
        //println(line.toUpperCase)
         //var sqlquery = query.replaceAll("\n", "   ")

        println(query)
       // sql("show tables").show()
        try {
          //sql(line)
          spark.sqlContext.sql(query)
          //spark.sqlContext.sql(sqlquery)
        } catch {
          case _ :  QueryExecutionException | _ : HiveException | _: NoSuchObjectException | _: ParseException =>
          println("error occurred  while Processing the create"  )
            //accumulable += (line)
          case exception: MetaException =>
            val msg = exception.getMessage
            //logger.warn("Parser error for frame\n" +  "\n\n" + msg)
            //logger.warn("Parse ")
            log.warn("Error occured" + msg)
            exception.printStackTrace()

          case unknown: Throwable => println("Got this unknown exception: " + unknown)
            log.error("unknown error : " + unknown)


        }

          }

          //bufferedSource.close
          spark.stop()

          }

  }


