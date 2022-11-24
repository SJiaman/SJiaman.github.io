package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/10 22:46
 * @Desc 函数的定义形式
 */

object TestFun03 {
  def main(args: Array[String]): Unit = {
    
    //（1）函数1：无参，无返回值
    def f1(): Unit = {
      println("无参，无返回值")
    }
    
    f1()
    
    //（2）函数2：无参，有返回值
    def f2(): Int = {
      println("无参，有返回值")
      return 10
    }
    
    println(f2())
    
    //（3）函数3：有参，无返回值
    def f3(name: String): Unit = {
      println("有参，无返回值")
    }
    
    println(f3("atguigu"))
    
    //（4）函数4：有参，有返回值
    def f4(name: String): String = {
      println("有参，有返回值")
      return "hello-->" + name
    }
    
    println(f4("atguigu"))
    
    //（5）函数5：多参，无返回值
    def f5(name1: String, name2: String): Unit = {
      println(s"${name1}和${name2}都是我的好朋友")
    }
    
    println(f5("jingjing", "juanjuan"))
    
    //（6）函数6：多参，有返回值
    
    def f6(a: Int, b: Int): Int = {
      println("多参，有返回值")
      return a + b
    }
    
    println(f6(10, 20))
    
  }
  
}
