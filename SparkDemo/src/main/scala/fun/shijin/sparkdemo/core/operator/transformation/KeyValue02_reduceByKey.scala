package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/4 21:04
 * @Desc 按照K聚合V
 */

object KeyValue02_reduceByKey {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("b", 3), ("java", 3), ("c", 8), ("java", 3), ("a", 3)))
    
    // 通过key 来计算相加结果
    val resRDD: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
    
    resRDD.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
