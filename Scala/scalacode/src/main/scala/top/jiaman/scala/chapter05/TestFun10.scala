package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/16 19:38
 * @Desc 控制抽象
 *       1）值调用：把计算后的值传递过去
 *       2）名调用：把代码传递过去
 *
 *       注意：Java只有值调用；Scala既有值调用，又有名调用。
 */

object TestFun10 {
  def main(args: Array[String]): Unit = {
  
    def f(): Int = {
      println("f...")
      10
    }
  
    //1）值调用：把计算后的值传递过去
    foo(f())
  
    //2）名调用：把代码传递过去
    foo1(f)
  }
  
  def foo(a: Int):Unit = {
    println(a)
    println(a)
  }
  
  def foo1(a: => Int): Unit ={
    println(a)
    println(a)
  }
  
}
