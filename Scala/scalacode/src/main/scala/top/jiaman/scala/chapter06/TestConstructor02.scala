package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:57
 * @Desc 构造方法的参数
 */

object TestConstructor02 {
  def main(args: Array[String]): Unit = {
    //val stdJ: Student09 = new Student09
    //stdJ.name = "jingjing"
    //stdJ.age = 16
    //println(stdJ.name)
    var std = new Student09("jingjing",17)
    println(std.name)
    std.m1()
  }
}

/*
//只提供无参的主构造，单独定义
class Student09{
  var name:String = _
  var age:Int = _
}
*/

/*
//在scala语言中，以下写法比较少，如果这样写，那就是受java毒害太深了
class Student09(namePararm:String,ageParam:Int){
  var name:String = namePararm
  var age:Int = ageParam
}
*/

//在声明主构造方法参数的时候，如果参数前什么也不加，那么参数就作为当前类的局部变量使用,不能作为类的属性被访问
//如果需要将参数作为属性被访问的话，那么在参数声明前加var或者val关键字
class Student09( var name:String, var age:Int){
  def m1(): Unit ={
    println(name)
    println(age)
  }
}
/*
//同时提供主、辅助构造方法
class Student09{
  var name:String = _
  var age:Int = _

  def this(name:String,age:Int){
    this()
    this.name = name
    this.age = age
  }
}*/