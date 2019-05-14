# SparkSqlProg

#To complile
sbt assembly 

#To RUN
/apache/spark/bin/spark-submit  --master yarn  --queue data-default   --driver-memory 8g --executor-memory 8g  --class "SparkSqlUpdater" /home/hadoop/SparkSqlProg-assembly-0.3.jar working/DDLFILE__05_05_19-10-54new  | tee ~/Rajesh-Sparklogs-DDLFILE__05_05_19-10-54new`date +%F-%T`
