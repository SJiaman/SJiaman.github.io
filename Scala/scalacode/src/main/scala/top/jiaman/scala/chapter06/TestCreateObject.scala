package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 20:36
 * @Desc 创建对象的方式
 *   -Java
 *     >new
 *     >反射
 *     >工厂
 *     >克隆
 *     >反序列化
 *   -Scala
 *     >new
 *       底层调用类的构造方法
 *     >类()
 *       底层调用的是apply方法
 *
 *     >apply方法定义在类的伴生对象中
 *
 *   -单例设计模式
 *     >构造方法私有化
 *     >提供私有静态属性，接收单例对象
 *     >公共的、静态的getInstance方法
 *
 */

object TestCreateObject {
  def main(args: Array[String]): Unit = {
    /*
    //通过new方式，底层调用的是构造方法创建对象
    val std1: Student15 = new Student15()
    println(std1)
    val std2: Student15 = new Student15("jingjing",18)
    println(std2)
    */
    //
    
    var std:Student15 = Student15("zs",20)
    println(std)
  }
}

object Student15{
  //无参apply方法创建对象
  def apply: Student15 = new Student15()
  
  //注意：apply方法并不一定创建是当前类型对象，也有可能是其他类型，但是很少使用
  //def apply(): String = new String("abc")
  //apply方法可以重载
  def apply(name:String,age:Int): Student15 = new Student15(name,age)
}

class Student15 private(){
  var name:String = _
  var age:Int = _
  
  private def this(name:String,age:Int){
    this()
    this.name = name
    this.age = age
  }
  override def toString = s"Student15($name, $age)"
}