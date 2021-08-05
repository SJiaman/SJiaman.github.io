package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:31
 * @Desc 类似全连接，但是在同一个RDD中对key聚合 RDD[(K, (Iterable[V], Iterable[W]))]
 */

object KeyValue10_cogroup {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val rdd: RDD[(Int, String)] = sc.makeRDD(List((1, "j"), (1, "i"), (3, "a"), (4, "man"), (5, "?")))
  
    val rdd1: RDD[(Int, String)] = sc.makeRDD(List((1, "n"), (1, "a"), (3, "m"), (4, "jia")))
  
    rdd1.cogroup(rdd).collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
