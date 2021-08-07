package fun.shijin.sparkdemo.core.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/7 20:38
 * @Desc RDD序列化
 *    因为在Spark程序中，算子相关的操作在Excutor上执行，算子之外的代码在Driver端执行，
 *    在执行有些算子的时候，需要使用到Driver里面定义的数据，这就涉及到了跨进程或者跨节点之间的通讯，
 *    所以要求传递给Excutor中的数组所属的类型必须实现Serializable接口
 */

object SerializableFunction {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
    
    val student1: student = new student
    student1.name = "zhangshan"
    
    val student2: student = new student
    student2.name = "wangwu"
    
    val rdd: RDD[student] = sc.makeRDD(List(student1, student2))
    
    rdd.collect().foreach(println)
    
    //4.关闭连接
    sc.stop()
    
  
  }
}

class student extends Serializable {
  var name: String = _
  
  override def toString: String = s"student($name)"
}