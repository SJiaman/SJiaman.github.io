package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:05
 * @Desc 惰性函数
 *  当函数返回值被声明为lazy时，函数的执行将被推迟，直到我们首次对此取值，该函数才会执行。这种函数我们称之为惰性函数。
 */

object TestFun11 {
  def main(args: Array[String]): Unit = {
    val res = sum(10, 20)
    println("--------------")
    println("res=" + res)
    
    //惰性声明
    println("-------lazy---------")
    lazy val res1 = sum(10, 20)
    println("-----------------")
    println("res=" + res1)
  }
  
  def sum(n1: Int, n2: Int): Int = {
    println("sum被执行...")
    return n1 + n2
  }
}
