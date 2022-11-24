package fun.shijin.scalabasic.chapter05

import scala.beans.BeanProperty

/**
 * @Author shijin
 * @Date 2021/6/3 10:18
 * @Desc
 */

object TestClass1 {
  def main(args: Array[String]): Unit = {
    val testClass = new TestClass
    println(testClass.line)
    testClass.setAge(19)
    println(testClass.getAge)
    val avg = testClass.avg(10, 8)
    println(avg)
  }
}

class TestClass {
  private var name: String = "张三"
  var line: String = "what ?"
  //@BeanProperty 自动生成get 和 set
  @BeanProperty var age:Int = _
  
  def avg(a:Int, b:Int):Int = {
    (a + b) / 2
  }
}

