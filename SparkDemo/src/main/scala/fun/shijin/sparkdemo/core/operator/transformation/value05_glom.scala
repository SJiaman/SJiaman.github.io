package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 15:39
 * @Desc 将RDD一个分区中的元素，组合成一个新的数组
 */

object value05_glom {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    
//    // 将RDD一个分区中的元素，组合成一个新的数组
//    val newRDD: RDD[Array[Int]] = RDD.glom()
//
//    newRDD.collect().foreach(
//      data => {
//      println(data.mkString(","))
//    })
    
    //求出每个分区的最大值
    val newRDD: RDD[Int] = RDD.glom().map(_.max)
  
    // 求出所有分区的最大值的和
    println(newRDD.collect().sum)
    
    //4.关闭连接
    sc.stop()
    
  }
}
