package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/13 18:21
 * @Desc 函数至简原则：能省则省
 *       至简原则细节
 *       （1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
 *       （2）如果函数体只有一行代码，可以省略花括号
 *       （3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
 *       （4）如果有return，则不能省略返回值类型，必须指定
 *       （5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
 *       （6）Scala如果期望是无返回值类型，可以省略等号
 *       （7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
 *       （8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
 *       （9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
 */

object TestFun05 {
  def main(args: Array[String]): Unit = {
    
    // (0)函数标准写法
    def f(s: String): String = {
      return s + " you are best!"
    }
    
    println(f("shijin"))
    
    //(1) return可以省略，Scala会使用函数体的最后一行代码作为返回值
    def f1(s: String): String = {
      s + " you can fly!"
    }
    
    println(f1("shijin"))
    
    //（2）如果函数体只有一行代码，可以省略花括号
    def f2(s: String): String = s + " you will win!"
    
    println(f2("shijin"))
    
    //（3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def f3(s: String) = s + " you are best!"
    
    println(f3("shijin"))
    
    //（4）如果有return，则不能省略返回值类型，必须指定
    def f4(): String = {
      return "shijin"
    }
    
    println(f4())
    
    //（5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
    def f5(): Unit = {
      return "shijin"
    }
    
    println(f5())
    
    //（6）Scala如果期望是无返回值类型，可以省略等号
    def f6() {
      println("shjin")
    }
    
    f6()
    
    //（7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def f7() = "shijin"
    
    println(f7())
    println(f7)
    
    //（8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def f8 = "shijin"
    
    println(f8)
    
    //（9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
    def f9 = (x: String) => {
      println("shijin")
    }
    
    def f10(f: String => Unit) = {
      f("")
    }
    
    f10(f9)
    println(f10((x: String) => {
      println("shijin")
    }))
    
  }
  
}
