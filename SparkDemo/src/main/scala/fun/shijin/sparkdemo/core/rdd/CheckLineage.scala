package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @Author shijin
 * @Date 2021/8/7 21:08
 * @Desc 查看血缘关系
 *       (12) ParallelCollectionRDD[0] at makeRDD at CheckLineage.scala:20 []
 *       =====================================
 *       (12) MapPartitionsRDD[1] at flatMap at CheckLineage.scala:24 []
 *       |   ParallelCollectionRDD[0] at makeRDD at CheckLineage.scala:20 []
 *       ======================================
 *       (12) ShuffledRDD[3] at groupBy at CheckLineage.scala:33 []
 *       +-(12) MapPartitionsRDD[2] at groupBy at CheckLineage.scala:33 []
 *       |   MapPartitionsRDD[1] at flatMap at CheckLineage.scala:24 []
 *       |   ParallelCollectionRDD[0] at makeRDD at CheckLineage.scala:20 []
 *       ======================================
 *       (12) MapPartitionsRDD[4] at map at CheckLineage.scala:39 []
 *       |   ShuffledRDD[3] at groupBy at CheckLineage.scala:33 []
 *       +-(12) MapPartitionsRDD[2] at groupBy at CheckLineage.scala:33 []
 *       |   MapPartitionsRDD[1] at flatMap at CheckLineage.scala:24 []
 *       |   ParallelCollectionRDD[0] at makeRDD at CheckLineage.scala:20 []
 **/

object CheckLineage {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val RDD: RDD[(String, Int)] = sc.makeRDD(List(("Hello Scala", 2), ("Hello Spark", 3), ("Hello World", 2)))
    println(RDD.toDebugString)
    println("=====================================")
    
    val flatMapRDD: RDD[(String, Int)] = RDD.flatMap { case (words, count) => {
      words.split(" ").map((_, count))
     }
    }
    
    println(flatMapRDD.toDebugString)
    
    println("======================================")
    
    val groupByRDD: RDD[(String, Iterable[(String, Int)])] = flatMapRDD.groupBy(_._1)
    
    println(groupByRDD.toDebugString)
    println("======================================")
    
    
    val resRDD: RDD[(String, Int)] = groupByRDD.map {
      case (word, datas) => {
        (word, datas.map(_._2).sum)
      }
    }
  
    println(resRDD.toDebugString)
    
    //4.关闭连接
    sc.stop()
  }
}
