package top.jiaman.scala.chapter06

import scala.beans.BeanProperty

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:46
 * @Desc
 */

object TestField {
  def main(args: Array[String]): Unit = {
    //创建对象
    val std: Student05 = new Student05()
    //通过对象.的方式访问属性
    std.name = "jingjing"
    println(std.name)
  
    println(std.sex)
  }
  
}
class Student05{
  //在Scala语言中，属性、方法、类默认的修饰是public
  //但是public 不能显式加  类似java中default
  //底层生成的字节码文件对属性用private进行修饰，提供了公开的获取|设置属性值的方法
  //作用1：符合面向对象的封装特性
   var name:String = "zhangsan"
  
  //如果想生成符合JavaBean规范的get|set方法，需要在属性上加一个注解@BeanProperty
  //作用2：对一些框架进行支持
  @BeanProperty
  var age:Int = 18
  
  //如果想给属性赋默认值，需要在声明的时候，赋_
  var sex:String = _
  
  
}