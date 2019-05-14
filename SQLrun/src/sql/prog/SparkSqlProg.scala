package sql.prog

import java.io.File

//import org.apache.spark.sql.Row
// $example on:init_session$
//import org.apache.spark.sql.SparkSession
// $example off:init_session$
// $example on:programmatic_schema$
// $example on:data_types$
//import org.apache.spark.sql.types._
// $example off:data_types$
// $example off:programmatic_schema$


class SparkSqlProg {

  def main(args: Array[String]): Unit = {
    println("Hello World!")

    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    val spark = SparkSession
      .builder()
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._
    import spark.sql


    sql("show tables").show()
    val dataDir = "/tmp/parquet_data"
    spark.range(10).write.parquet(dataDir)


    spark.stop()

  }


}
