package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 14:03
 * @Desc
 *抽象类和特质关系
 *   -抽象类中可以定义抽象属性、抽象方法、非抽象属性、非抽象方法
 *   -特质中可以定义抽象属性、抽象方法、非抽象属性、非抽象方法
 *   -抽象类和特质都不能被实例化
 *     >抽象类有构造方法
 *     >特质也有构造方法
 *   -如果需要给构造方法传递参数的话，使用抽象类，因为特质不支持带参的构造
 *   -优先选择特质，scala是单继承，如果直接继承不方便后续的扩展
 *   -多大量对象共性进行抽象--->类--->对大量类共性进行抽象-->抽象类
 *     一般子类和父类之间应该满足   is-a 原则
 *   -特质一般是对行为进行抽象，定义规范
 */

object TestTraitAndAbstract {
  def main(args: Array[String]): Unit = {
    val ma = new MyAbstract("caiji") {
      override def m1(): Unit = {
        println("woshicaiji")
      }
    }
    ma.m1()
  }
}
trait Trait1 {
  println("特质的构造方法")
  def m1()
}

abstract class MyAbstract (name: String) {
  println("抽象类的构造方法")
  def m1():Unit
}

