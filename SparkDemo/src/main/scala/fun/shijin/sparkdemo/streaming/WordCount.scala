package fun.shijin.sparkdemo.streaming

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

/**
 * @Author shijin
 * @Date 2021/8/9 8:56
 * @Desc Spark Streaming 创建word count
 */

object WordCount {
  def main(args: Array[String]): Unit = {
    // 创建配置文件对象
    val conf: SparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
    
    // 创建 Streaming 上下文环境
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(3))
    
    // 从7777 端口读取数据
    val line: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop111", 7777)
  
    // 数据转换
    val word: DStream[String] = line.flatMap(_.split(" "))
    
    val wordCount: DStream[(String, Int)] = word.map((_, 1)).reduceByKey(_ + _)
    
    // 数出结果
    wordCount.print()
    
    // 启动采集器
    ssc.start()
    
    // 等待采集结束，终结上下文对象
    ssc.awaitTermination()
  }
}
