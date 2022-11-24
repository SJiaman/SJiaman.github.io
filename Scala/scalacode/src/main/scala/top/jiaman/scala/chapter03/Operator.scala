package top.jiaman.scala.chapter03

/**
 * @Author Jiaman
 * @Date 2021/1/9 20:50
 * @Desc
 */

object Operator {
  def main(args: Array[String]): Unit = {
    /*
//---------------算术运算符---------------
//（1）对于除号“/”，它的整数除和小数除是有区别的：整数之间做除法时，只保留整数部分而舍弃小数部分。
var r1: Int = 10 / 3 // 3
println("r1=" + r1)

var r2: Double = 10 / 3 // 3.0
println("r2=" + r2)

var r3: Double = 10.0 / 3 // 3.3333
println("r3=" + r3)
println("r3=" + r3.formatted("%.2f")) // 含义：保留小数点2位，使用四舍五入
*/
    //---------------比较运算符---------------
    
    //          Java
    //            ==比较的是对象的内存地址
    //            equals 默认和==一样，也是比较的地址，String对equals方法进行了重写，字符串的equals比较的是内容
    //          Scala
    //            ==和equals功能一样，比较的是内容是否相同
    
    
    var s1: String = new String("abc")
    var s2: String = "abc"
    println(s1 == s2) //true
    println(s1.equals(s2)) //true
    println(s1.eq(s2)) //false
    
    //在Java语言中，+=运算符可以自动进行强转，但是在Scala语言中，+=底层不会自动进行强转
    //var b:Byte = 10
    //var b:Int = 10
    //b += 1
    //println(b)
    
    
    //        var n1:Int = 3
    //        var n2:Int = 3
    //
    //        var n3:Int = n1 + n2
    //        println(n3)
    //        println(10.toString())
    //        println(10 toString)
  }
}
