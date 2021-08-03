package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 17:39
 * @Desc 通过groupby实现word count
 */

object value06_groupby_WC {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("Hello Scala", 2), ("Hello Spark", 3), ("Hello World", 2)))
    
    val flatMapRDD: RDD[(String, Int)] = RDD.flatMap { case (words, count) => {
      words.split(" ").map((_, count))
      }
    }
  
    flatMapRDD.collect().foreach(println)
    println("======================================")
    
    val groupByRDD: RDD[(String, Iterable[(String, Int)])] = flatMapRDD.groupBy(_._1)
  
    groupByRDD.collect().foreach(println)
    println("======================================")
  
  
    val resRDD: RDD[(String, Int)] = groupByRDD.map {
      case (word, datas) => {
        (word, datas.map(_._2).sum)
      }
    }
    
    resRDD.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
