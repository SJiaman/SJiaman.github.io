package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 20:15
 * @Desc 匿名子类
 */

abstract class Person {
  val name: String
  def hello(): Unit
}

object AnonymousSubclassTest {
  def main(args: Array[String]): Unit = {
  
    //抽象类不能被实例化   可以通过匿名子类的方式创建对象
    val person = new Person {
      override val name: String = "teacher"
      override def hello(): Unit = println("hello teacher")
    }
  
    println(person.name)
    person.hello()
  }
}


