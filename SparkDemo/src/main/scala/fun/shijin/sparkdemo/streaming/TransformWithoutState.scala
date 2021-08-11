package fun.shijin.sparkdemo.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author shijin
 * @Date 2021/8/11 17:11
 * @Desc  无状态的 转换
 */

object TransformWithoutState {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("TransformWithoutState").setMaster("local[*]")
  
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(3))
    
    val inputStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop201", 7777)
  
    val resDStream: DStream[(String, Int)] = inputStream.transform(rdd => {
      val wordCount: RDD[(String, Int)] = rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
      wordCount
    })
    
    resDStream.print()
    
    ssc.start()
    ssc.awaitTermination()
  }
}
