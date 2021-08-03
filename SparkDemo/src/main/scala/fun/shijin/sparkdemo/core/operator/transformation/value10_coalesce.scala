package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 18:21
 * @Desc -coalesce
 *       默认是不执行shuffle，一般用于缩减分区
 *       注意：默认情况下，如果使用coalesce扩大分区是不起作用的  。因为底层没有执行shuffle
 */

object value10_coalesce {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //3.创建一个RDD
    val rdd: RDD[Int] = sc.makeRDD(Array(1, 2, 3, 4), 4)
  
    rdd.mapPartitionsWithIndex(
      (index, data) => {
        println(index + "------" + data.mkString(","))
        data
      }
    ).collect()
    
    val coalesceRDD: RDD[Int] = rdd.coalesce(2)
  
    coalesceRDD.mapPartitionsWithIndex(
      (index, data) => {
        println(index + "------" + data.mkString(","))
        data
      }
    ).collect()
    
    //4.关闭连接
    sc.stop()
    
  }
}
