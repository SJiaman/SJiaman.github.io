package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 11:22
 * @Desc 特质的声明与混入
 */

object TestTrait01 {
  def main(args: Array[String]): Unit = {
    var a: PersonTraint17 = new MyClass17
    println(a.name)
    a.eat()
  }
}

//特质的声明
trait PersonTraint17 {
  //抽象属性
  var name: String
  
  //抽象方法
  def eat(): Unit
  
  //非抽象属性
  var age: Int = 10
  
  //非抽象方法
  
  def sleep(): Unit = {
    println("Person's sleep")
  }
}

//混入特质
class MyClass17 extends PersonTraint17 {
  override var name: String = "shijin"
  
  override def eat(): Unit = {
    println("jiaman eat")
  }
}
