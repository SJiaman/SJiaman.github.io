package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/16 20:02
 * @Desc
 */

object MyWhile {
  def main(args: Array[String]): Unit = {
    var i: Int = 1
    myWhile(i <= 10) {
      println(i)
      i += 1
    }
  }
  
  def myWhile(condition: => Boolean)(op: => Unit): Unit = {
    if (condition) {
      op
      myWhile(condition)(op)
    }
  }
  
}
