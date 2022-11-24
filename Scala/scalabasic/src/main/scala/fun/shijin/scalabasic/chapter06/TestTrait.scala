package fun.shijin.scalabasic.chapter06

/**
 * @Author shijin
 * @Date 2021/6/5 11:05
 * @Desc
 */
////接口
//// 可以有抽象的属性和方法
//trait TestTrait {
//  var num:String = _
//  def test:Unit = {
//    println(":::")
//  }
//  // 抽象方法和变量
//  var age:Int
//  def test1:Unit
//  def test2
//}
//
//trait TestTrait1 {
//  println("scala_trait")
//}
//// 继承 extends ... with
//
//class Test extends TestTrait with TestTrait1 {
//  override var age: Int = 19
//
//  override def test1: Unit = println("dashijin")
//
//  override def test2: Unit = println("nothing")
//}
//// 如果一个类在继承特质和父类时，应该把父类写在extends后
//
//class Father {
//  println("father")
//}
//
//class Test1 extends Father with TestTrait1 {
//}
//
////所有的Java接口都可以当作Scala特质使用
//class Test2 extends java.io.Serializable{
//
//}
//
//class Scala_Father {
//  println("父类构造")
//}
//
//trait Scala_Trait {
//  println("父特质构造")
//}
//
//trait Scala_Trait2 extends Scala_Trait {
//  println("子特质构造1")
//}
//
//trait Scala_Trait3 extends Scala_Trait {
//  println("子特质构造2")
//}
//
//class Scala_Son extends Scala_Father with Scala_Trait3 with Scala_Trait2 {
//  println("子类构造")
//}
//
//object Scala_Test {
//  def main(args: Array[String]): Unit = {
//    // 1.父类的构造函数执行，多个trait从左到右依次执行
//    val son = new Scala_Son
//    println(son)
//
//    // 2.构造trait时候会先构造父 trait
//    // 3.如果多个trait继承同一个父trait，则父trait只会构造一次
//    // 4.所有trait构造完毕后，子类的构造函数执行
//  }
//}

// 接收参数的构造函数的：没有接收参数的构造函数的
//8. 接收参数的构造函数的:没有接收参数的构造函数的
//trait Scala_Trait {
//  val msg:String=""
//  println(msg.toString)
//}
//
//class Scala_Class extends Scala_Trait {
//  override val msg: String = "test"
//}
//
//object Scala_Object {
//  def main(args: Array[String]): Unit = {
//    val clazz = new Scala_Class //报错
//  }
//}

//9. 提前定义
//trait  Scala_Trait {
//  val msg: String = ""
//  println(msg.toString)
//}

//class Scala_Class extends Scala_Trait {
//  override val msg: String = "testtt"
//}
//
//object Scala_Object {
//  def main(args: Array[String]): Unit = {
//    val clazz = new Scala_Class //报异常
//  }
//}
//class  Scala_Class extends {override val msg="testtt"} with Scala_Trait {
//  println("提前定义")
//}
//
//object Scala_Object1 {
//  def main(args: Array[String]): Unit = {
//    val clazz = new Scala_Class
//  }
//}

// 11.lazy
//trait Scla_Trait {
//  lazy  val msg: String = ""
//  println(msg.toString)
//}
//
//class  Scala_Class extends Scla_Trait {
//  println("lazy方法")
//  override lazy val msg: String = "te"
//}
//
//object Scala_Object {
//  def main(args: Array[String]): Unit = {
//    val clazz = new Scala_Class
//  }
//}

// 12.包
//package com {
//  package guida {
//    package testscala {
//    }
//  }
//}

// 13.异常
object Scala_Exception {
  def main(args: Array[String]): Unit = {
//    var num = 10 / 0 报错
    var num1 = try {
      10 / 0
    } catch {
      case ec1:ArithmeticException => {println("ArithmeticException")}
      case ec2:Exception => {println("Exception")}
    } finally {
      println("finally")
    }
  }
}
