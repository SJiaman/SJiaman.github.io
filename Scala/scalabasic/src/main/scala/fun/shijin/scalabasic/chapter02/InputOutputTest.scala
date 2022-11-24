package fun.shijin.scalabasic.chapter02

/**
 * @Author shijin
 * @Date 2021/5/15 10:29
 * @Desc
 */

object InputOutputTest {
  def main(args: Array[String]): Unit = {
//    // 键盘输入
//    println("请输入年龄：")
//    val age:Int = StdIn.readInt()
//
//    println("请输入姓名：")
//    val name = StdIn.readLine()
//
//    println(age + name)
//
//    println("请输入一个整数：")

//    val num1 = StdIn.readInt()
//    val num2 = StdIn.readLong()
//    val num3 = StdIn.readFloat()
//
//    val num4:Double = num1 + num2 + num3
//    println(num4)
    
    val char1:Char = 98
    val num5:Int = char1
    
//    val num6:Byte = char1
    
    val num7:Byte = 104
    val num8:Short = num7
    
    val num9 = num7 + num8
//    num9 //Int
    
    var num10:Any = num9
    println(num10) //Any
    
    val num11:Double = 11.5
    val num12:Int = num11.toInt
    println(num12)
    
    val num14:Float = 16.2f
    
    val num13 = num7 + num11 + num14.toInt
    println(num13)
    
    val num15:Char = num11.toChar
    
    val num16:String = "111"
    val num17:Long = num16.toLong
    
    val num18:String = "afhfa"
    val num19:Int = num18.toInt
    println(num19)
  }
}
