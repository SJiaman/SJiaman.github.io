package fun.shijin.scalabasic.chapter04

/**
 * @Author shijin
 * @Date 2021/5/27 17:04
 * @Desc
 */

object TestFun02 {
  def main(args: Array[String]): Unit = {
    def fun01(): Unit = {
      println("这是一个函数")
    }
    
    fun01()
    
    
    def fun02() {
      println("这是一个省略函数 ': Unit =' ")
    }
    
    fun02()
    
    def fun03() = println("这是一个省略函数 ': Unit = {}'")
    
    fun03()
    
    val add = (num1: Int, num2: Int) => {
      num1 + num2
    }
  
    println(add(1, 2))
    
    
  }
}
