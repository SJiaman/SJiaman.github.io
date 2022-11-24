package fun.shijin.scalabasic.chapter03

import scala.util.control.Breaks._

/**
 * @Author shijin
 * @Date 2021/5/27 8:41
 * @Desc
 */

object TestWhile {
  def main(args: Array[String]): Unit = {
    
     // while循环， i 需要在外面定义
    var i = 0
//    while (i < 10) {
//      if (i % 2 == 1) {
//        println(i)
//      }
//
//      i += 1
//    }
    
    // Scala的break用法
    while (i < 10) {
      breakable{
        i += 1
        if (i == 5)
          break()
        println(i)
      }
    }
    
    // do while 的使用，do while至少执行一个循环体，while可能一次都不执行
    do {
      i += 1
      println(i)
    } while (i < 11)
    
    
  }
}
