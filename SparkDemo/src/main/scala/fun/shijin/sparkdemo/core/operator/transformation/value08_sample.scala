package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 18:02
 * @Desc 从数据中采样
 */

object value08_sample {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[Int] = sc.makeRDD(1 to 10, 2)
    
    // 随机抽样放回
    val sampleRDD: RDD[Int] = rdd.sample(true, 1)
    
    //随机抽样不放回
   // val sampleRDD: RDD[Int] = rdd.sample(false, 1)
    
    val takeSampleRDD: Array[Int] = rdd.takeSample(false, 1)
  
    takeSampleRDD.foreach(println)
    //4.关闭连接
    sc.stop()
    
  }
}
