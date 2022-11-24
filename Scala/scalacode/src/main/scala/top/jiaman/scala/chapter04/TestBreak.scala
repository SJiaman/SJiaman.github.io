package top.jiaman.scala.chapter04

import scala.util.control.Breaks.{break, breakable}

/**
 * @Author Jiaman
 * @Date 2021/1/9 20:57
 * @Desc: 循环中断
 *        -continue
 *        终止当前正在执行的本次循环， 继续下一次
 *        -break
 *        终止整个循环
 *        -在scala语言中，没有break和continue关键字的
 *        >通过在循环体中加条件判断实现continue效果
 *        >通过抛出异常的方式实现break效果
 */

object TestBreak {
  def main(args: Array[String]): Unit = {
    
    try {
      for (i <- 1 to 5) {
        if (i == 3) {
          //跳出整个循环
          throw new RuntimeException
        }
        println(i)
      }
    } catch {
      //捕获异常，并对其进行处理
      case e: NullPointerException => {}
    }
    
    
    //标记当前循环是可中断的
    breakable(
      for (i <- 1 to 5) {
        if (i == 3) {
          //跳出整个循环
          break
        }
        println(i)
      }
    )
    
    
    println("这是循环体之外的代码")
    
  }
  
}
