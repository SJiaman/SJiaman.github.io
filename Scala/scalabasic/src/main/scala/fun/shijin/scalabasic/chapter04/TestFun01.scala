package fun.shijin.scalabasic.chapter04

import scala.io.StdIn

/**
 * @Author shijin
 * @Date 2021/5/27 11:43
 * @Desc
 */

object TestFun01 {
  def main(args: Array[String]): Unit = {
    def fun01(num01: Int): Unit = {
      num01 match {
        case 1=> println("大哥")
        case 2=> println("小弟")
        case 3=> println("余额不足")
      }
    }
  
    println("请输入一个数")
    val i = StdIn.readInt()
    fun01(i)
    
    def fun02(num01: Int, num02: Int): Int = {
      num01 * num02
    }
    
    println("")
    
  }
}
