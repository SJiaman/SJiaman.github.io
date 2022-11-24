package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 20:09
 * @Desc
 */

object TestAbstract02 {
  def main(args: Array[String]): Unit = {
    val student = new Student12
    student.eat()
    student.sleep()
    println(student.age)
    println(student.name)
  }
}
abstract class Person12{
  //非抽象属性
  val name:String = "zhangsan"
  
  //抽象属性
  var age:Int
  
  //非抽象方法
  def eat(): Unit ={
    println("Person's eat")
  }
  
  //抽象方法
  def sleep():Unit
}

class Student12 extends Person12 {
  //在Scala语言中，重写除了方法之外，还要属性的重写
  //在子类中 ，如果重写的是抽象属性和方法，那么override关键字可以省略
  var age: Int = 18
  
  def sleep(): Unit = {
    println("banzhang sleep")
  }
  
  //对父类的非抽象方法进行重写
  //override关键字不能省略，必须得加
  override def eat(): Unit = {
    //可以通过super关键字，取调用父类的方法
    super.eat()
    
    //但是不能通过super关键字，访问父类的属性
    //println(super.name)
    //println(super.age)
    
    println("Student‘s eat")
  }
  
  //父类声明了抽象属性  ，子类对属性进行实现
  //父类声明了非抽象属性  ，子类对属性进行重写
  //如果子类需要对父类的属性进行重写，属性只能是val修饰
  //override var name:String = "jingjing"
  override val name: String = "jingjing"
}