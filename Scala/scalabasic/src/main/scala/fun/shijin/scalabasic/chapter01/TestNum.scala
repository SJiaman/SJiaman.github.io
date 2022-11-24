package fun.shijin.scalabasic.chapter01

/**
 * @Author shijin
 * @Date 2021/5/13 8:34
 * @Desc
 */

object TestNum {
  def main(args: Array[String]): Unit = {
    val a:Byte = 1
  
    val num3:Int = 2147483647
    
    val num4 = 2147483647
    //Scala里不写类型，整数类型会自动推断Int类型
    
    val num1:Long = 99999999999L
    val num2:Long = 1221212122
    
    //超出Int涵盖范围，不加L报错，不超出Int范围，不加L也不报错
    
    println(Long.MaxValue)
    println(Long.MinValue)
    
    val numChar = 97
    println(numChar)
    
    val numChar1 = 'a'
    println(numChar1)
    
//    val numChar4:Char = 999999  整数超出Unicode的编码范围 报错
    
    val numChar2 = numChar1 + 1
//    val numChar2:Char = numChar1 + 1 报错
    println(numChar2)
    
    val numChar3:Char = '\n'
    println("特殊字符类型：-------" + numChar3 + "------------")
    
    val testUnit: Unit = ()
    println(testUnit)
    
    def testUnit2_1:Int = {
      print("Int返回值")
      22
    }
    
    val testUnit2 = testUnit2_1
    
    testUnit2
    
  }
}
