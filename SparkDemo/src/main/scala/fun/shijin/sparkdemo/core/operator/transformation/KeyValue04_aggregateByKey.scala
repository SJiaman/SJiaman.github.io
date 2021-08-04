package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/4 21:20
 * @Desc 转换算子-aggregateByKey
 *   -按照key对分区内以及分区间的数据进行处理
 *   -aggregateByKey(初始值)(分区内计算规则,分区间计算规则)
 */

object KeyValue04_aggregateByKey {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 2), ("b", 5), ("c",9), ("b", 19), ("c", 6)), 2)
    
    rdd.mapPartitionsWithIndex(
      (index, value) => {
        println(index + "-------" + value.mkString(","))
        value
      }
    ).collect()
    
    // 实现word count
    rdd.aggregateByKey(0)(_ + _ , _ + _).collect().foreach(println)
  
    // 求各个分区中的最大的数，分区间相乘
    val resRDD: RDD[(String, Int)] = rdd.aggregateByKey(0)(
      (x, y) => math.max(x, y),
      (a, b) => a * b
    )
    
    resRDD.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
