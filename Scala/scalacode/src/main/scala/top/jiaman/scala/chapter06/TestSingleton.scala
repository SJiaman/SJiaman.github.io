package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 20:41
 * @Desc 单例对象
 *   -懒汉式
 *   -饿汉式
 *       >构造方法私有化
 *       >提供私有静态属性，接收单例对象
 *       >公共的、静态的getInstance方法
 *
 */

object TestSingleton {
  def main(args: Array[String]): Unit = {
    val std1: Student16 = Student16.getInstance()
    println(std1)
    val std2: Student16 = Student16.getInstance()
    println(std2)
  }
}

//懒汉式
object Student16{
  private var s:Student16 = null
  def getInstance():Student16={
    if(s == null){
      s = new Student16
    }
    s
  }
}
//饿汉式
/*object Student16{
  private var s:Student16 = new Student16
  def getInstance():Student16={
    s
  }
}*/
//主构造方法私有化
class Student16 private(){}