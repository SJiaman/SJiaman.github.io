package fun.shijin.sparkdemo.streaming

import kafka.common.TopicAndPartition
import kafka.message.MessageAndMetadata
import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka.{HasOffsetRanges, KafkaUtils, OffsetRange}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author shijin
 * @Date 2021/8/11 15:37
 * @Desc 使用Direct api 连接Kafka
 */

object DStreamLinkKafkaWithDirect {
  def main(args: Array[String]): Unit = {
//    val conf: SparkConf = new SparkConf().setAppName("directdemo").setMaster("local[*]")
//
//    val ssc: StreamingContext = new StreamingContext(conf, Seconds(3))
//
//    //准备Kafka参数
//    val kafkaParams: Map[String, String] = Map[String, String](
//      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "hadoop201:9092,hadoop202:9092,hadoop203:9092",
//      ConsumerConfig.GROUP_ID_CONFIG -> "bigdata"
//    )
//
//    val fromOffsets: Map[TopicAndPartition, Long] = Map[TopicAndPartition, Long](
//      TopicAndPartition("directdemo", 0) -> 10L,
//      TopicAndPartition("directdemo", 1) -> 10L,
//      TopicAndPartition("directdemo", 2) -> 10L
//    )
//
//    val kafkaDs: InputDStream[String] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder, String](
//      ssc,
//      kafkaParams,
//      fromOffsets,
//      (m: MessageAndMetadata[String, String]) => m.message()
//    )
//
//    var offsetRange: Array[OffsetRange] = Array.empty[OffsetRange]
//
//    kafkaDs.transform {
//      rdd => {
//        offsetRange = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
//        rdd
//      }
//    }.foreachRDD{
//      rdd => {
//        for (o <- offsetRange) {
//          println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
//        }
//      }
//    }
//
//    ssc.start()
//
//    ssc.awaitTermination()
  
    //创建配置文件对象
    val conf: SparkConf = new SparkConf().setAppName("DirectAPI_Hander").setMaster("local[*]")
  
    //创建SparkStreaming上下文环境对象
    val ssc: StreamingContext = new StreamingContext(conf,Seconds(3))
  
    //准备Kafka参数
    val kafkaParams: Map[String, String] = Map[String, String](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "hadoop201:9092,hadoop202:9092,hadoop203:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "bigdata",
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer"
    )
  
    //获取上一次消费的位置（偏移量）
    //实际项目中，为了保证数据精准一致性，我们对数据进行消费处理之后，将偏移量保存在有事务的存储中， 如MySQL
    var  fromOffsets:Map[TopicAndPartition,Long] = Map[TopicAndPartition,Long](
      TopicAndPartition("directdemo", 0) -> 1L,
      TopicAndPartition("directdemo", 1) -> 1L,
      TopicAndPartition("directdemo", 2) -> 1L
    )
  
    //从指定的offset读取数据进行消费
    val kafkaDstream: InputDStream[String] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder, String](
      ssc,
      kafkaParams,
      fromOffsets,
      (m: MessageAndMetadata[String, String]) => m.message()
    )
  
    //消费完毕之后，对偏移量offset进行更新
    var offsetRanges: Array[OffsetRange] = Array.empty[OffsetRange]
  
    kafkaDstream.transform{
      rdd=>{
        offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
        rdd
      }
    }.foreachRDD{
      rdd=>{
        for (o <- offsetRanges) {
          println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
        }
      }
    }
  
    ssc.start()
    ssc.awaitTermination()
  }
}
