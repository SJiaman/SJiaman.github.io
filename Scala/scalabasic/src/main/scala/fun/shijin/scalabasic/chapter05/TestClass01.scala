package fun.shijin.scalabasic.chapter05

/**
 * @Author shijin
 * @Date 2021/6/3 11:37
 * @Desc
 */

class TestClass01(name1: String) {
  var name:String = name1
  var age:Int = _
  println("主构造器")
  
  // 辅助构造器不能直接构造对象，必须直接或间接的调用主构造方法
  def this(age:Int) {
    this("ff")
    println("辅助构造器")
    this age = age
  }
  
  // 可以有多个辅助构造器，通过参数来区分
  def this(age:Int, num:Int) {
    this(3)
    println("辅助构造器2")
    this age = age + num
  }
}

object Test1 {
  def main(args: Array[String]): Unit = {
    val zhangsan = new TestClass01("zhangsan")
    println(zhangsan.age)
  }
}