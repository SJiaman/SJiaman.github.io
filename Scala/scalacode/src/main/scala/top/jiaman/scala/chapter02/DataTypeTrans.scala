package top.jiaman.scala.chapter02

/**
 * @Author Jiaman
 * @Date 2020/12/2 16:34
 * @Desc 类型转换
 */

object DataTypeTrans {
  def main(args: Array[String]): Unit = {
    val b: Byte = 10
    println(b.toInt) //10
    val d: Double = 1.2234
    println(d.toByte) //1
    
    var num: Int = 10 * 3.5.toInt + 6 * 1.5.toInt
    var num2: Int = (10 * 3.5 + 6 * 1.5).toInt
    println(num + " " + num2) //36 44
  }
}
