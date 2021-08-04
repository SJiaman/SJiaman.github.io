package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/4 21:11
 * @Desc
 * 1）reduceByKey：按照key进行聚合，在shuffle之前有combine（预聚合）操作，返回结果是RDD[k,v]。
 * 2）groupByKey：按照key进行分组，直接进行shuffle。
 * 3）开发指导：在不影响业务逻辑的前提下，优先选用reduceByKey。求和操作不影响业务逻辑，求平均值影响业务逻辑。
 */

object KeyValue03_groupByKey {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 2), ("b", 3), ("hello", 10), ("a", 3), ("hello", 4)))
    
    val groupByKeyRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()
    
    groupByKeyRDD.collect().foreach(println)
    
    groupByKeyRDD.map(
      data => (data._1, data._2.sum)
    ).collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
