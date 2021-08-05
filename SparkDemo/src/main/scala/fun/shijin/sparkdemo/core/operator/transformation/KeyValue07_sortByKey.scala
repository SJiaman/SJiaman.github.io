package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:17
 * @Desc   //如果key为自定义类型，要求必须混入Ordered特质
 */

object KeyValue07_sortByKey {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 2), ("b", 3), ("hello", 10), ("a", 3), ("hello", 4)))
    
    // 按照key,升序排列
//    rdd.sortByKey(true).collect().foreach(println)
    
    // 降序
    rdd.sortByKey(false).collect().foreach(println)
    
    
    //4.关闭连接
    sc.stop()
    
  }
}
