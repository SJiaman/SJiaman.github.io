package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:25
 * @Desc 将相同key对应的多个value关联在一起
 */

object KeyValue09_join {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[(Int, String)] = sc.makeRDD(List((1, "j"), (2, "i"), (3, "a"), (4, "man"), (5, "?")))
    
    val rdd1: RDD[(Int, String)] = sc.makeRDD(List((1, "n"), (2, "a"), (3, "m"), (4, "jia")))
    
    //将相同key对应的多个value关联在一起 join算子相当于内连接，将两个RDD中的key相同的数据匹配，如果key匹配不上，那么数据不关联
    rdd1.join(rdd).collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
