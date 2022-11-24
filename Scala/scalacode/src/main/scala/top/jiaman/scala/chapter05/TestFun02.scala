package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/10 22:36
 * @Desc
 * -函数和方法
 * *函数
 * 完成某个特殊功能的代码块
 * *函数和方法定义的位置不一样
 * 函数:定义在方法或者函数内部
 * 方法:定义在类下的函数，叫方法
 *
 * *方法支持重写和重载，但是函数不允许
 * 重载对调用者可以屏蔽掉因为方法参数不同而造成差异
 */

object TestFun02 {
  
  def sayHi(name: String): Unit = {
    println("hello --> " + name)
  }
  
  def sayHi(age: Int): Unit = {
    println("jiaman --> " + age)
  }
  
  def main(args: Array[String]): Unit = {
    
    sayHi("jiaman")
    sayHi(21)
    
    def sayHello(name: String, age: Int): Unit = {
      println("hello -->" + name + " age --> " + age)
    }
    
    sayHello("jiaman", 21)
  }
  
}
