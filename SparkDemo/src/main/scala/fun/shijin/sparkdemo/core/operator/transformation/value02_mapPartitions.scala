package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 15:22
 * @Desc value型，转换算子 - mapPartitions
 */

object value02_mapPartitions {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    
    // 调用mapPartitions 根据分区转换每个数据乘2
    val newRDD: RDD[Int] = RDD.mapPartitions(data => data.map(_ * 2))
    
    newRDD.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
