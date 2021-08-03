package fun.shijin.sparkdemo.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author Jiaman
 * @Date 2021/1/26 21:32
 * @Desc spark word count
 */

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WC").setMaster("local[*]")
    
    val sc = new SparkContext(conf)
    
    val lineRdd: RDD[String] = sc.textFile("F:\\Demo\\bigdata\\SparkDemo\\src\\main\\resources\\input")
    
    val wordRdd: RDD[String] = lineRdd
      .flatMap(line => line.split(" "))
    
    val wordToOneRdd: RDD[(String,Int)] = wordRdd.map(word => (word, 1))
    
    val wordToSumRdd: RDD[(String, Int)] = wordToOneRdd.reduceByKey((v1, v2) => v1 + v2)
    
    val wordToCountArray: Array[(String, Int)] = wordToSumRdd.collect()
    
    wordToCountArray.foreach(println)
//
//    sc.textFile("F:\\Exercise\\bigdata\\SparkDemo\\src\\main\\resources\\input")
//      .flatMap(_.split(" "))
//      .map((_,1))
//      .reduceByKey(_ + _)
//      .saveAsTextFile("F:\\Exercise\\bigdata\\SparkDemo\\src\\main\\resources\\input1")
    
    sc.stop()
  }
}
