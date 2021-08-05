package fun.shijin.sparkdemo.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:36
 * @Desc f函数聚集RDD中的所有元素，先聚合分区内数据，再聚合分区间数据。
 */

object Action01_reduce {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //3具体业务逻辑
    //3.1 创建第一个RDD
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
  
    //3.2 聚合数据
    val reduceResult: Int = rdd.reduce(_+_)
    println(reduceResult)
  
  
    //4.关闭连接
    sc.stop()
    
  }
}
