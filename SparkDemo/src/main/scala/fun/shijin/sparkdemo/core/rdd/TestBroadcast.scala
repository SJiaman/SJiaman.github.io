package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

/**
 * @Author shijin
 * @Date 2021/8/8 14:46
 * @Desc 广播变量 只读
 */

object TestBroadcast {
  def main(args: Array[String]): Unit = {
    //创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
  
    //创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //想实现类似join效果   (a,(1,4)),(b,(2,5)),(c,(3,6))
    val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3)))
    val list: List[(String, Int)] = List(("a",4),("b",5),("c",6))
  
    //创建一个广播变量
    val broadcastList: Broadcast[List[(String, Int)]] = sc.broadcast(list)
  
    val resRDD: RDD[(String, (Int, Int))] = rdd.map {
      case (k1, v1) => {
        var v3 = 0
        //for ((k2, v2) <- list) {
        for ((k2, v2) <- broadcastList.value) {
          if (k1 == k2) {
            v3 = v2
          }
        }
        (k1, (v1, v3))
      }
    }
    resRDD.collect().foreach(println)
  
    // 关闭连接
    sc.stop()
  }
}
