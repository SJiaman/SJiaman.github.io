package fun.shijin.scalabasic.chapter05

/**
 * @Author shijin
 * @Date 2021/6/3 17:18
 * @Desc
 */

class TestExtends {
  
}

class Father(name1: String) {
  var name:String = name1
  var age:Int = _
  println("父主构造器")
  def this(age:Int) {
    this("父轴")
    this.age = age
    println("父辅构造器")
  }
}

class Son(name1:String) extends Father(name1) {
  var namez:String = name1
  var agez:Int = _
  println("子主构造器")
  def this(age:Int) {
    this("子辅")
    println("子辅助构造器")
    this.agez = age
  }
}

object Test2 {
  def main(args: Array[String]): Unit = {
    val son = new Son("张三")
    val son1 = new Son(19)
  
    println(son.namez)
    println(son1.agez)
  }
}