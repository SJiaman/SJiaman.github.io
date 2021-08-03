package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/2/16 19:02
 * @Desc value型，转换算子 - map
 */

object value01_map {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    
    val rdd: RDD[Int] = sc.makeRDD(1 to 4, 2)
    
    val mapRdd = rdd.map(_ * 2)
    
    mapRdd.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
  }
}
