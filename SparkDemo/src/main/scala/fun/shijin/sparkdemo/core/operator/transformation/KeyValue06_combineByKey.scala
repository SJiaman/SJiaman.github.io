package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 9:45
 * @Desc
 */

object KeyValue06_combineByKey {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
  
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    // 求各科的平均成绩
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("java", 99), ("scala", 87), ("python", 77), ("scala", 69), ("scala", 85), ("java", 79)), 2)
  
    val resRDD: RDD[(String, (Int, Int))] = rdd.combineByKey(
      (_, 1),
      (tup: (Int, Int), v) => (tup._1 + v, tup._2 + 1),
      (x: (Int, Int), y: (Int, Int)) => (x._1 + y._1, x._2 + y._2)
    )
    
    resRDD.collect().foreach(println)
  
    resRDD.map {
      case (k, v) => {
        (k, v._1 / v._2)
      }
    }.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
  
  }
  
}
