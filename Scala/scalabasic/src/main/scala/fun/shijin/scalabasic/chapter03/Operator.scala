package fun.shijin.scalabasic.chapter03

/**
 * @Author shijin
 * @Date 2021/5/20 8:27
 * @Desc
 */

object Operator {
  def main(args: Array[String]): Unit = {
    val num1:Int = 3
    val num2:Int = 23
    val num5:Double = 23.0
    
    // 整数除运算，取整部分
    val num3:Int = num2 / num1
    println(num3)
    
    // 浮点数运算，结果完整
    val num4:Double = num5 / num1
    println(num4)
    
    val num6:Int = num2 % num1
    println(num6)
    
    // 关系运算
    println(num3 == num4)
    println(num1 != num2)
    
    // 逻辑运算
    println(num3 == num4 || num1 != num2)
    
    println(num3 == num4 && num1 != num2)
    
    
  }
}
