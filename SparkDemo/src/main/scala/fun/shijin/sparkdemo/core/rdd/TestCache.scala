package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel

/**
 * @Author shijin
 * @Date 2021/8/7 21:19
 * @Desc RDD持久化
 *      cache  底层调用的是persist函数   默认缓存在内存中
 *      persist可以接收参数，指定缓存位置
 *      当应用程序程序执行结束之后，缓存的目录也会被删除
 */

object TestCache {
  def main(args: Array[String]): Unit = {
    //创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    //创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //创建RDD
    val rdd: RDD[String] = sc.makeRDD(List("hello java","hello scala"),2)
  
    //扁平映射
    val flatMapRDD: RDD[String] = rdd.flatMap(_.split(" "))
  
    //结构转换
    val mapRDD: RDD[(String, Int)] = flatMapRDD.map {
      word => {
        println("------------------------")
        (word, 1)
      }
    }
  
    //打印血缘关系
    println(mapRDD.toDebugString)
 
    //mapRDD.cache()
    
    //mapRDD.persist()
    mapRDD.persist(StorageLevel.DISK_ONLY)
  
    //触发行动操作
    mapRDD.collect()
  
    println("---------------------------------------")
  
    //打印血缘关系
    println(mapRDD.toDebugString)
    //触发行动操作
    mapRDD.collect()
  
    // 关闭连接
    sc.stop()
  }
}
