package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 20:07
 * @Desc 抽象
 *   -模糊、不具体
 *   -使用abstract关键字定义抽象类
 *   -抽象类一般和抽象属性以及抽象方法配合使用
 *     >抽象属性
 *       属性只有声明，但是没有赋值
 *
 *     >抽象方法
 *       方法只有声明，没有实现
 *
 *    -在一个类中，如果存在抽象属性或者抽象方法，那么这个类一定是抽象类
 *    -如果一个类是抽象类，那么它不一定包含抽象属性和抽象方法
 *    -如果一个类中存在抽象属性或者抽象方法，那么具体的实现应该交给子类完成
 *    -如果子类也实现不了抽象内容，那么子类也应该声明为抽象类
 *
 */

object TestAbstract01 {
  def main(args: Array[String]): Unit = {
    val yGSon = new YGSon
    yGSon.move()
    
    val ygws = new YGWS
    ygws.move()
  }
}
//愚公移山
abstract class YG{
  //移山
  def move():Unit
}

class YGSon extends YG{
  override def move(): Unit = {
    println("使用锤子糟山")
  }
}

abstract class YGDau extends YG{
  
  def f1(): Unit ={
  
  }
}

class YGWS extends YGDau{
  override def move(): Unit = {
    println("蓝翔~~~")
  }
  
}
