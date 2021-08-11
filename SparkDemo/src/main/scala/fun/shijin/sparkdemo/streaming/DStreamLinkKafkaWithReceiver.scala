package fun.shijin.sparkdemo.streaming


import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Author shijin
 * @Date 2021/8/10 10:53
 * @Desc 与Kafka连接使用
 */

object DStreamLinkKafkaWithReceiver {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("DStream-Kafka").setMaster("local[*]")
  
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(3))
  
    //kafka参数声明
    val brokers = "hadoop201:9092,hadoop202:9092,hadoop203:9092"
    val topic = "sparkdemo"
    val group = "bigdata"
    val deserialization = "org.apache.kafka.common.serialization.StringDeserializer"
    val kafkaParams = Map(
      ConsumerConfig.GROUP_ID_CONFIG -> group,
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> deserialization,
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> deserialization
    )
    //创建DS
    val kafkaDS: InputDStream[(String, String)] = KafkaUtils
      .createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, Set(topic))
  
    // 数据转换
    val resDS: DStream[(String, Int)] = kafkaDS.map(_._2).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    
    resDS.print()
  
    ssc.start()
    
    ssc.awaitTermination()
  }
}
