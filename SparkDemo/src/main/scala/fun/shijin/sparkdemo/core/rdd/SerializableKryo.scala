package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/7 20:58
 * @Desc kryo序列化框架使用 需要在SparkConf中替换和注册
 */

object SerializableKryo {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf()
      .setAppName("SparkCoreTest")
      .setMaster("local[*]")
      // 替换默认的序列化机制
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      // 注册需要使用 kryo 序列化的自定义类
      .registerKryoClasses(Array(classOf[Searcher]))
  
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val rdd: RDD[String] = sc.makeRDD(Array("hello world", "hello jiaman", "jiaman", "hahah"), 2)
  
    val searcher = new Searcher("jiaman")
    
    val result: RDD[String] = searcher.getMatchedRDD1(rdd)
  
    result.collect.foreach(println)
  
  
    //4.关闭连接
    sc.stop()
    
  }
}

case class Searcher(val query: String) {
  
  def isMatch(s: String) = {
    s.contains(query)
  }
  
  def getMatchedRDD1(rdd: RDD[String]) = {
    rdd.filter(isMatch)
  }
  
  def getMatchedRDD2(rdd: RDD[String]) = {
    val q = query
    rdd.filter(_.contains(q))
  }
}
