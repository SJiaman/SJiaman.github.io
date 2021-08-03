package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 18:30
 * @Desc -repartition
 *      底层调用的就是coalesce，只不过默认是执行shuffle，一般用于扩大分区
 */

object value11_repartition {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[Int] = sc.makeRDD(2 to 10, 2)
  
    rdd.mapPartitionsWithIndex(
      (index, data) => {
        println(index + "------" + data.mkString(","))
        data
      }
    ).collect()
    
    println("========扩大分区后==========")
    val repartitionRDD: RDD[Int] = rdd.repartition(4)
  
    repartitionRDD.mapPartitionsWithIndex(
      (index, data) => {
        println(index + "------" + data.mkString(","))
        data
      }
    ).collect()
    
    //4.关闭连接
    sc.stop()
    
  }
}
