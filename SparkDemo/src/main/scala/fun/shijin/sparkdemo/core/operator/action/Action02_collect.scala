package fun.shijin.sparkdemo.core.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/5 10:39
 * @Desc 以数组Array的形式返回数据集的所有元素
 */

object Action02_collect {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[Int] = sc.makeRDD(List(1, 3, 4, 6, 9), 2)
    
    rdd.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
