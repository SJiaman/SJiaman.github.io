package fun.shijin.scalabasic.chapter03

import scala.io.StdIn

/**
 * @Author shijin
 * @Date 2021/5/20 9:42
 * @Desc
 */

object TestIf {
  def main(args: Array[String]): Unit = {
    println("亲亲，你在做什么？\n1.看书 2.写代码 3，玩游戏")
    var num:Int = StdIn.readInt()
    if (num == 1) {
      println("你肯定很聪明！")
    } else if (num == 2) {
      println("写代码一定很有趣吧！")
    } else {
      println("你真的爱玩！")
    }
  }
}
