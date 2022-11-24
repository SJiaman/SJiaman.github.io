package fun.shijin.scalabasic.chapter05

/**
 * @Author shijin
 * @Date 2021/6/5 8:56
 * @Desc
 */

//9.伴生对象
//1.当单例对象与某个类共享同一个名称时，它就被称为是这个类的伴生对象(companion object)
//2.类和它的伴生对象必须定义在同一个源文件中。类被称为是这个单例对象的伴生类。
//3.类和它的伴生对象可以互相访问其私有成员
//4.单例对象中的属性和方法都可以通过伴生对象名（类名〉直接调用访问。
//5.不使用new方法创建对象:通过伴生对象的apply方法
//6.如果想让主构造器变成私有的,可以在()之前加上private。
//7.apply方法可以重载。


//class Scala_Class {
//  private var num: Int = 1
//  //通过伴生对象名(类名)可以直接访问类成员
//  Scala_Class.line
//}
//
//
//object Scala_Class {
//
//  //伴生对象（类名相同且参数也相同）可以访问相应对象的私有成员，而object修饰的静态类（单例对象）没有伴生对象
//  //类与他的伴生对象要在同一个源文件中
//  //
//  private var line: String = "111"
//
//  def main(args: Array[String]): Unit = {
//    val clazz = new Scala_Class
//    //伴生对象可以访问类的私有成员
//    println(clazz.num)
//  }
//
//
//}

class Scala_Class(nu: Int) {
  var num: Int = nu
}

object Scala_Class {
  var line: String = "111"
  
  def apply(): Scala_Class = {
    println("apply无参")
    new Scala_Class(1)
  }
  
  def apply(nu: Int): Scala_Class = {
    println("apply有参")
    new Scala_Class(nu)
  }
  
  def apply(nu: Int, name: String): Scala_Class = {
    println("apply有参")
    new Scala_Class(nu)
  }
}

object Test_OC {
  def main(args: Array[String]): Unit = {
    // 创建对象方式1：
    val clazz = new Scala_Class(2)
    println(clazz)
    
    //    // 创建对象方式2：
    val clazz2 = Scala_Class()
    println(clazz2)
    
    //3.apply方法可以重载
    val clazz1 = Scala_Class(2222)
    println(clazz1)
    
    // 4.apply方法创建对象，用参数匹配方式
    val scala_Class4 = Scala_Class(1111,"sss")
    println(scala_Class4)
    
  }
}