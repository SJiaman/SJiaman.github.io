package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
 * @Author shijin
 * @Date 2021/8/8 11:23
 * @Desc 累加器的使用 分布式共享只写变量
 *
 */

object TestAccumulator {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
//    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("a", 8), ("a", 4), ("a", 2)))
//
//    // 统计a, 出现的次数。有shuffle
//    rdd.reduceByKey(_ + _).collect().foreach(println)
//
//    // 自定义累加器，算出a的出现次数，没有shuffle
//    val sum: LongAccumulator = sc.longAccumulator("sum")
//
//    rdd.foreach{
//      case (index, count) => {
//        sum.add(count)
//      }
//    }
  
    //3. 创建RDD
    val rdd: RDD[String] = sc.makeRDD(List("Jiaman", "Hello", "Jiaman", "Json", "json", "Spark", "Spark"))
  
    //3.1 创建累加器
    val accumulator1: MyAccumulator = new MyAccumulator()
  
    //3.2 注册累加器
    sc.register(accumulator1,"wordcount")
  
    //3.3 使用累加器
    rdd.foreach(
      word =>{
        accumulator1.add(word)
      }
    )
  
    //3.4 获取累加器的累加结果
    println(accumulator1.value)
  
  
    //4.关闭连接
    sc.stop()
    
  }
}

// 自定义累加器
class MyAccumulator extends AccumulatorV2[String, mutable.Map[String, Long]] {
  var map: mutable.Map[String, Long] = mutable.Map[String, Long]()
  
  override def isZero: Boolean = map.isEmpty
  
  override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = {
    new MyAccumulator()
  }
  
  override def reset(): Unit = map.clear()
  
  override def add(v: String): Unit = {
    if (v.startsWith("J")) {
      map(v) = map.getOrElse(v, 0L) + 1L
    }
  }
  
  override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {
    var map1 = map
    var map2 = other.value
    
    map = map1.foldLeft(map2){
      (map,kv)=>{
        map(kv._1) = map.getOrElse(kv._1, 0L) + kv._2
        map
      }
    }
    
  }
  
  override def value: mutable.Map[String, Long] = map
}
