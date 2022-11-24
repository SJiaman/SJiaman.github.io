package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:49
 * @Desc
 * 访问权限
 * Java
 * -private                  只能在当前类中被访问
 * -default(默认)             当前类以及同包的其他类
 * -protected                当前类以及同包的其他类以及非同包的子类
 * -public                   所有类
 *
 * Scala
 * -在scala中，类、方法、属性默认就是public修饰，但是没有public关键字
 * -private      私有的，只能在当前类以及伴生对象中使用
 * -protected    受保护的，比Java中的权限设置更加严格，同类、子类可以访问，同包其它类不能访问
 * -private[包名]  包访问权限，在指定的包下的其它类也可以访问
 */

object TestPrivilege01 {
  def main(args: Array[String]): Unit = {
    val person = new Person06
    person.m1()
    println(person.age)
    println(person.sex)
  }
}

class Person06 {
  private var idCard: String = "10000"
  protected var name: String = "banzhang"
  private[chapter06] var age: Int = 40
  var sex: String = "男"
  
  def m1(): Unit = {
    println(idCard)
    println(name)
    println(age)
    println(sex)
  }
  
}
