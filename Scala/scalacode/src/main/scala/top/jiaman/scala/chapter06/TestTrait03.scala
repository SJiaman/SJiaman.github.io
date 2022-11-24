package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 13:42
 * @Desc 特质的普通冲突
 *>一个类混入多个特质，多个特质之间有相同的抽象方法，特质之间没有关系,直接对抽象方法实现一次即可
 *    >一个类混入多个特质，多个特质之间有相同的非抽象方法，特质之间没有关系,如果在类中不处理，会报错，特质冲突
 *    应该对相同的非抽象方法进行重写
 */

object TestTrait03 {
  def main(args: Array[String]): Unit = {
    val mc = new MyClass19
    mc.m1()
  }
}

/*trait TraitA1{
  def m1():Unit={
    println("TraitA1 m1")
  }
}

trait TraitB1{
  def m1():Unit={
    println("TraitB1 m1")
  }
}

class MyClass19 extends TraitA1 with TraitB1{
  override def m1(): Unit = {
    println("m1的实现")
  }
}*/

trait TraitA1{
  def m1():Unit
}

trait TraitB1{
  def m1():Unit
}

class MyClass19 extends TraitA1 with TraitB1{
  override def m1(): Unit = {
    println("m1的实现")
  }
}