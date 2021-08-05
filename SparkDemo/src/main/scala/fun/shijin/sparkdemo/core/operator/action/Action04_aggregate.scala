package fun.shijin.sparkdemo.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:56
 * @Desc
 */

object Action04_aggregate {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
    rdd.mapPartitionsWithIndex(
      (index, value) => {
        println(index + "-------" + value.mkString(","))
        value
      }
    ).collect()
    
    val res: Int = rdd.aggregate(0)(_ + _, _ + _) // ((1 + 2) + 10 + (3 + 4) + 10) + 10
    println(res)
    
    val res1: Int = rdd.aggregate(10)(_ + _, _ + _) // 40
    println(res1)
    
    //4.关闭连接
    sc.stop()
    
  }
}
