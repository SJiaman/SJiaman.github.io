package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 17:58
 * @Desc -按照指定的过滤规则，对RDD中的元素进行过滤
 */

object value07_filter {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    
    // 过滤掉不是2的倍数的数
    val filterRDD: RDD[Int] = RDD.filter(_ % 2 == 0)
    
    filterRDD.collect().foreach(println)
    //4.关闭连接
    sc.stop()
    
  }
}
