package fun.shijin.sparkdemo.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:46
 * @Desc
 */

object Action03_DataFetch {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[Int] = sc.makeRDD(List(1, 8, 4, 2, 3, 4, 5, 6,7, 8, 9), 3)
    
    // 3.1 count() 统计rdd中元素个数
    val elementCount: Long = rdd.count()
    println(elementCount)
    
    // 3.2 first() 返回rdd中第一个元素
    val firstElement: Int = rdd.first()
    println(firstElement)
    
    // 3.3 take() 返回前n个元素
    val takeN: Array[Int] = rdd.take(3)
    takeN.foreach(println)
    
    // 3.4takeOrdered()返回该RDD排序后前n个元素组成的数组
    val takeOrderN: Array[Int] = rdd.takeOrdered(3)
    takeOrderN.foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
