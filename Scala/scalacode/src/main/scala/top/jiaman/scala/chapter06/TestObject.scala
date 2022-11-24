package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:21
 * @Desc 对象和类
 *       -在自然界中，只要是客观存在的都是对象(万物皆对象)
 *       -对大量对象共性进行抽象，抽象类
 *       >有什么     属性
 *       >能做什么   方法
 *       >属性和方法虽然定义在类中，但是属于每一个对象
 *       -在Java|Scala语言中，类是创建对象的模板
 *       -类是客观事物在人脑中的主观反映
 *
 *       package 包
 *       import
 *       class 类名 extends 父类 implements 接口
 *       属性
 *       方法
 *       构造方法
 */


object TestObject {
  def main(args: Array[String]): Unit = {
    //创建对象
    val std: Student01 = new Student01
    println(std.name)
    std.study()
  }
}

//定义一个类
class Student01 {
  var name: String = "jingjing"
  def study(): Unit = {
    println(s"${name}在学习")
  }
}