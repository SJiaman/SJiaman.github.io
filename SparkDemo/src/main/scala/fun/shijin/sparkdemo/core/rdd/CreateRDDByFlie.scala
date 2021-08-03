package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/1/29 22:14
 * @Desc
 */

object CreateRDDByFlie {
  def main(args: Array[String]): Unit = {
    //创建SparkConf，设置app名称
    val conf: SparkConf = new SparkConf()
      .setAppName("SparkCreateRDDTest")
      .setMaster("local[*]")
    
    //创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    
    val lineWordRdd: RDD[String] = sc.textFile("F:\\Exercise\\bigdata\\SparkDemo\\src\\main\\resources\\input")
    
    lineWordRdd.foreach(println)
    
    sc.stop()
  }
}
