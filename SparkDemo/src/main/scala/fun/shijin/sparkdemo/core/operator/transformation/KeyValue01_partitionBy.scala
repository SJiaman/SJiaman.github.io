package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/4 19:48
 * @Desc  KeyValue型转换算子 -- 按照K重新分区
 */

object KeyValue01_partitionBy {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[(Int, String)] = sc.makeRDD(Array((1, "aaa"), (2, "bbb"), (3, "ccc")), 3)
   
    rdd.mapPartitionsWithIndex(
      (index, value) => {
        println(index + "--------------" + value.mkString(","))
        value
      }
    ).collect()
    
    println("=============")
    val newRDD: RDD[(Int, String)] = rdd.partitionBy(new MyPartitioner(2))
    
    newRDD.mapPartitionsWithIndex(
      (index, value) => {
        println(index + "--------------" + value.mkString(","))
        value
      }
    ).collect()
    
    
    //4.关闭连接
    sc.stop()
    
  }
}

// 自定义分区器
class MyPartitioner(partitions: Int) extends Partitioner {
  // 设置的分区数
  override def numPartitions: Int = partitions
  
  // 具体分区逻辑
  override def getPartition(key: Any): Int = {
    if (key.isInstanceOf[Int]) {
      val k: Int = key.asInstanceOf[Int]
      if (k % 2 == 0)
        0
      else
        1
    } else
      0
  }
}