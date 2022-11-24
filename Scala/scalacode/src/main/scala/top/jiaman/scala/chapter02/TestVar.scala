package top.jiaman.scala.chapter02

/**
 * @Author Jiaman
 * @Date 2020/11/3 12:21
 * @Desc
 */

object TestVar {
  def main(args: Array[String]): Unit = {
    //（1）声明变量时，类型可以省略，编译器自动推导，即类型推导
    var age = 18
    age = 30
    println(age)
    
    //（2）类型确定后，就不能修改，说明Scala是强数据类型语言。
    //        age = "tom" // 错误
    
    //（3）变量声明时，必须要有初始值
    //        var name //错误
    
    //（4）在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改。
    var num1 = 10 // 可变
    val num2 = 20 // 不可变
    
    num1 = 30 // 正确
    println(num1);
    //num2 = 100  //错误，因为num2是val修饰的
    println(num2);
    
    // p1是var修饰的
    // p1的属性可以变
    // 而且p1本身也可以变
    var p1 = new Person()
    p1.name = "dalang"
    p1 = null
    println(p1)
    
    // p2是val修饰的，那么p2本身就不可变（即p2的内存地址不能变），但是，p2的属性是可以变，因为属性并没有用val修饰。
    val p2 = new Person()
    p2.name = "jinlian"
    // p2 = null // 错误的，因为p2是val修饰的
    println(p2.name)
  }
  
  class Person {
    var name: String = "jinlian"
  }
  
}
