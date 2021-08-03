package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 18:34
 * @Desc
 */

object value12_sortBy {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //3具体业务逻辑
    // 3.1 创建一个RDD
    val rdd: RDD[Int] = sc.makeRDD(List(2, 1, 3, 4, 6, 5))
    // 3.2 默认是升序排
    val sortRdd: RDD[Int] = rdd.sortBy(num => num)
    sortRdd.collect().foreach(println)
  
    // 3.3 配置为倒序排
    val sortRdd2: RDD[Int] = rdd.sortBy(num => num, false)
    sortRdd2.collect().foreach(println)
  
    // 3.4 创建一个RDD
    val strRdd: RDD[String] = sc.makeRDD(List("1", "22", "12", "2", "3"))
  
    // 3.5 按照字符的int值排序
    strRdd.sortBy(num => num.toInt).collect().foreach(println)
  
    // 3.5 创建一个RDD
    val rdd3: RDD[(Int, Int)] = sc.makeRDD(List((2, 1), (1, 2), (1, 1), (2, 2)))
  
    // 3.6 先按照tuple的第一个值排序，相等再按照第2个值排
    rdd3.sortBy(t=>t).collect().foreach(println)
  
  
    //4.关闭连接
    sc.stop()
    
  }
}
