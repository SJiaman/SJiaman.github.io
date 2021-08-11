package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel

/**
 * @Author shijin
 * @Date 2021/8/8 10:19
 * @Desc 检查点的使用
 */

object TestCheckpoint {
  def main(args: Array[String]): Unit = {
     // 设置访问HDFS集群的用户名
//      System.setProperty("HADOOP_USER_NAME","jiaman")
  
    //创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    //创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    // 需要设置路径.需要提前在HDFS集群上创建/checkpoint路径
//    sc.setCheckpointDir("hdfs://hadoop102:9000/checkpoint")
    sc.setCheckpointDir("F:\\Demo\\bigdata\\SparkDemo\\src\\main\\resources\\checkpoint")
    
    //创建RDD
    val rdd: RDD[String] = sc.makeRDD(List("hello java","hello scala"),2)
  
    //扁平映射
    val flatMapRDD: RDD[String] = rdd.flatMap(_.split(" "))
  
    //结构转换
    val mapRDD: RDD[(String, Int)] = flatMapRDD.map {
      word => {
        println("------------------------")
        (word, 1)
      }
    }
  
    //打印血缘关系
    println(mapRDD.toDebugString)
  
    //mapRDD.cache()
  
    //mapRDD.persist()
    // 设置缓存
    mapRDD.persist(StorageLevel.DISK_ONLY)
    
    // 设置检查点
    mapRDD.checkpoint()
  
    //触发行动操作
    mapRDD.collect().foreach(println)
  
    println("---------------------------------------")
  
    //打印血缘关系
    println(mapRDD.toDebugString)
    //触发行动操作
    mapRDD.collect().foreach(println)
  
    Thread.sleep(1000000)
    // 关闭连接
    sc.stop()
  }
}
