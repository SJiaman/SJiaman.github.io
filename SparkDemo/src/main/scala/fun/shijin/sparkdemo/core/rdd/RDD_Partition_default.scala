package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @Author shijin
 * @Date 2021/3/15 21:44
 * @Desc
 */

object RDD_Partition_default {
  def main(args: Array[String]): Unit = {
      //创建SparkConf并设置App名称
      val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
      //创建SparkContext，该对象是提交Spark App的入口
      val sc: SparkContext = new SparkContext(conf)
    
      //通过集合创建RDD
//      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    
      //通过读取外部文件创建RDD
      val rdd: RDD[String] = sc.textFile("F:\\Exercise\\bigdata\\SparkDemo\\src\\main\\resources\\1.text")
      //查看分区效果
      //println(rdd.partitions.size)
      rdd.saveAsTextFile("F:\\Exercise\\bigdata\\SparkDemo\\src\\main\\resources\\output")
    
      // 关闭连接
      sc.stop()
  }
}
