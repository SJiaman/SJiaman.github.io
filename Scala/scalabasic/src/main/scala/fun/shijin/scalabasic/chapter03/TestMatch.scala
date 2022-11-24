package fun.shijin.scalabasic.chapter03

import scala.io.StdIn

/**
 * @Author shijin
 * @Date 2021/5/20 16:22
 * @Desc
 */

object TestMatch {
  def main(args: Array[String]): Unit = {
    println("亲亲，你在做什么？\n1.看书 2.写代码 3，玩游戏")
    var num: Int = StdIn.readInt()
    
    // case _=> 上的匹配能用，case _=> 下的匹配不能用
    num match {
      case 1 => println ("你肯定很聪明！")
      case _=> println("你到底在干啥呀！")
      case 2 => println ("写代码一定很有趣吧！")
      case 3 => println ("你真的爱玩！")
    }
  }
}
