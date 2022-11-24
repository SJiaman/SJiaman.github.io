package fun.shijin.scalabasic.chapter03

import scala.io.StdIn
import Array._

/**
 * @Author shijin
 * @Date 2021/5/20 9:43
 * @Desc
 */

object TestFor {
  def main(args: Array[String]): Unit = {
    //    for (i <- 1 to 10) {
    //      if (i % 2 == 0)
    //        println(i)
    //    }
    //
    //    for (i <- 1 until 10) {
    //      if (i % 3 == 0)
    //        println(i)
    //    }
    //
    // 循环守卫
    //    for (i <- 1 until 10 if i != 2) {
    //      println(i)
    //    }
    //
    // 循环步长
    //    for (i <- Range(1, 10, 2)) {
    //      println(i)
    //    }
    //
    //    for (i <- 1 to 10 by 2)
    //      println(i)
    
    // for嵌套循环 九九乘法表
    //    for (i <- 1 to 9; j <- 1 to i) {
    //      print(s"$j * $i = " + i * j + "\t")
    //      if (j == i)
    //        println()
    //    }
    //
    //    for (i <- 1 to 9) {
    //      for (j <- 1 to i) {
    //        print(s"$j * $i = " + i * j + "\t")
    //      }
    //      println()
    //    }
    
    //    for {
    //      i <- 1 to 10
    //      j = i * i
    //    } println(j)
    //
    //
    //    var num = for (i <- 1 to 10 ) yield i * i
    //    println(num)
    
    //统计三个班的学生成绩,每个班有5名学生,求出各个班级的平均分和所有班级的平均分,
    // 学生成绩从键盘输入
    
    var score1: Array[Double] = new Array[Double](5)
    var score2: Array[Double] = new Array[Double](5)
    var score3: Array[Double] = new Array[Double](5)
  
    println("请输入1个班的成绩：")
    for (i <- 0 until (score1.length)) {
      var score = StdIn.readDouble()
      score1.update(i, score)
    }
    
    fun(score1)
    println("请输入2个班的成绩：")
    for (i <- 0 until (score2.length)) {
      var score = StdIn.readDouble()
      score2.update(i, score)
    }
    println("请输入3个班的成绩：")
    for (i <- 0 until (score3.length)) {
      var score = StdIn.readDouble()
      score3.update(i, score)
    }
    
   
    
    println("1班的平均成绩是：")
    
    def fun(array: Array[Double]): Unit = {
  
      var sum: Double = 0
      var avg: Double = 0
      for (i <- score1) {
        sum +=i
      }
      println(sum)
      avg = sum / 5
      println("平均分为：" + avg)
    }
  }
}
