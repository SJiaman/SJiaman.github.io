package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/1/29 21:58
 * @Desc
 */

object CreateRDDByArray {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("SparkCreateRDDTest").setMaster("local[*]")
    
    //创建SparkContext,该对象是spark app的入口
    val sc: SparkContext = new SparkContext(conf)
   
    //使用parallelize创建RDD
    val rdd: RDD[Int] = sc.parallelize(Array(1,2,3,4,5,6,7,8))
    rdd.foreach(println)
    print("分区数：" + rdd.partitioner.size)
    
    //使用makeRDD()创建RDD
    val rdd1 = sc.makeRDD(Array(1,2,3,4,5,6,7,8))
    rdd1.foreach(println)
    print("分区数：" + rdd1.partitioner.size)
    
    sc.stop()
  }
}
