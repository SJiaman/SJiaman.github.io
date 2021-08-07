package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @Author shijin
 * @Date 2021/8/7 21:13
 * @Desc 查看依赖关系 RDD和它依赖的父RDD（s）的关系有两种不同的类型，
 *      即窄依赖（narrow dependency）和宽依赖（wide dependency）。
 *      宽依赖的 transformations 包括: sort, reduceByKey, groupByKey, join, 和调用rePartition函数的任何操作. Shuffle
 *       List()
 *       =====================================
 *       List(org.apache.spark.OneToOneDependency@42fcc7e6)
 *       ======================================
 *       List(org.apache.spark.ShuffleDependency@7186333e)
 *       ======================================
 *       List(org.apache.spark.OneToOneDependency@627d8516)
 **/

object CheckDependencies {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
  
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("Hello Scala", 2), ("Hello Spark", 3), ("Hello World", 2)))
    println(RDD.dependencies)
    println("=====================================")
  
    val flatMapRDD: RDD[(String, Int)] = RDD.flatMap { case (words, count) => {
      words.split(" ").map((_, count))
    }
    }
  
    println(flatMapRDD.dependencies)
  
    println("======================================")
  
    val groupByRDD: RDD[(String, Iterable[(String, Int)])] = flatMapRDD.groupBy(_._1)
  
    println(groupByRDD.dependencies)
    println("======================================")
  
  
    val resRDD: RDD[(String, Int)] = groupByRDD.map {
      case (word, datas) => {
        (word, datas.map(_._2).sum)
      }
    }
  
    println(resRDD.dependencies)
  
    //4.关闭连接
    sc.stop()
  }
}
