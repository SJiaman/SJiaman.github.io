package fun.shijin.sparkdemo.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * @Author shijin
 * @Date 2021/8/9 9:32
 * @Desc 通过RDD队列来创建
 */

object DStreamCreateWithRDDQueue {
  def main(args: Array[String]): Unit = {
    // 创建配置文件
    val conf: SparkConf = new SparkConf().setAppName("rdd-queue-streamcreate").setMaster("local[*]")
  
    // 创建流式上下文 环境
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(3))
  
    // 创建RDD队列
    val rddQueue: mutable.Queue[RDD[Int]] = new mutable.Queue[RDD[Int]]
  
    // 创建队列流
    val inputStream: InputDStream[Int] = ssc.queueStream(rddQueue, oneAtATime = false)
  
    val resStream: DStream[(Int, Int)] = inputStream.map((_, 1)).reduceByKey(_ + _)
    
    resStream.print()
    
    ssc.start()
    
    // 向队列中添加RDD
    for (i <- 1 to 5) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 5, 2)
      Thread.sleep(2000)
    }
    
    ssc.awaitTermination()
  }
}
