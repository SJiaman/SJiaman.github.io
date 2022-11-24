package fun.shijin.scalabasic.chapter04

/**
 * @Author shijin
 * @Date 2021/6/3 8:22
 * @Desc 高阶函数
 */

object TestFun03 {
  def main(args: Array[String]): Unit = {
    def fun01(a:Int, b:Int, c:(Int, Int) => Int): Int = {
      c(a, b)
    }
    
    def max(x:Int, y:Int):Int = {
      if (x > y) x
      else y
    }
    
    val test01 = fun01(2, 5, max)
    println(test01) // 5
    
    val test02 = fun01(2, 5, (x, y) => x + y)
    println(test02) // 7
  
    val test03 = fun01(2, 5, _*_)
    println(test03) // 10
//    def fun2(i: Int): Int = {
//      i * 2
//    }
//
//    def fun22(f: Int => Int): Int = {
//      f(10)
//    }
//
//    println(fun22(fun2))
//
//    def fun3( i:Int ): Int = {
//      i * 2
//    }
//    def fun33( ) = {
//      fun3 _
//    }
//    println(fun33()(10))

    def fun04(name:String, age:Int=89): Unit ={
      println("-------" + name)
      println("----------------" + age)
    }
    fun04("菜鸟", 15)
  
  }
}
