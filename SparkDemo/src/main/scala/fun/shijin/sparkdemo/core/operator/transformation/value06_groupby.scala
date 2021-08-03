package fun.shijin.sparkdemo.core.operator.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/3 15:56
 * @Desc 将数据根据指定的规则进行分组（根据函数的返回值）, 分区默认不变，但是数据会被打乱重新组合，我们将这样的操作称之为shuffle
 */

object value06_groupby {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    val RDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    
    // 根据对2求模来分组
    val newRDD1: RDD[(Int, Iterable[Int])] = RDD.groupBy(_ % 2)
    
    newRDD1.collect().foreach(println)
  
    // 根据单词来分组
    val RDD2: RDD[String] = sc.makeRDD(List("Java","hello","scala","Java","hello","scala"))
  
    val newRDD2: RDD[(String, Iterable[String])] = RDD2.groupBy(elem=>elem)
  
    newRDD2.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  }
}
