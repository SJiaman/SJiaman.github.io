package fun.shijin.sparkdemo.core.rdd

import java.sql.DriverManager

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Author shijin
 * @Date 2021/8/8 10:43
 * @Desc MySQL连接使用
 */

object TestMySQL {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf并设置App名称
    val conf: SparkConf = new SparkConf().setAppName("SparkCoreTest").setMaster("local[*]")
    
    //2.创建SparkContext，该对象是提交Spark App的入口
    val sc: SparkContext = new SparkContext(conf)
  
    //3.定义连接mysql的参数
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/bbs"
    val username = "root"
    val password = "759260"
  
    val resRDD: JdbcRDD[(Int, String, Int, String, Int)] = new JdbcRDD(sc, () => {
      Class.forName(driver)
      DriverManager.getConnection(url, username, password)
    },
      "select * from section where ? <= sec_id and sec_id <= ?", // 必须要有两个参数
      1,
      3,
      2,
      res => (res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5))
    )
    resRDD.collect().foreach(println)
  
    //4.关闭连接
    sc.stop()
    
  }
}
