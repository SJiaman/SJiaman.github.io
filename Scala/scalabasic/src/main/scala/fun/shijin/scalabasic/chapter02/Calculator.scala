package fun.shijin.scalabasic.chapter02

import scala.io.StdIn

/**
 * @Author shijin
 * @Date 2021/5/20 8:23
 * @Desc
 */
object Calculator {
  def main(args: Array[String]): Unit = {
    println("请输入一个数字：")
    var num1 = StdIn.readDouble()
    println("请输入运算符：")
    var sign = StdIn.readChar()
    println("请输入第二个数字(必须为整型）:")
    var num2 = StdIn.readInt()
    
    var PI:Double=3.1415926
    //Any是所有类型的超类
    var tips:Any = "恭喜你运算成功！"
    var tips1:Any = "暂时未实现这类功能！"
    
    if (sign == '+') {
      //数据类型自动靠齐,Double
      println(num1+num2)
    }
    else if(sign=='-'){
      println(num1-num2)
    }
    else if(sign=='*'){
      //强制类型转换,Int
      println(num1.toInt*num2.toInt)
    }
    else if(sign=='/'){
      if (num2==0){
        println("除数不为零")
      }
      println(num1.toInt/num2.toInt)
    }
    else if(sign=='r'){
      println("计算圆周率：")
      //强制类型转换Float
      var area1:Float=(PI*num1.toInt*num1.toInt).toFloat
      println("第一个圆面积："+area1)
      var area2:Float=(PI*num2*num2).toFloat
      println("第二个圆面积："+area2)
    }
    else{
      println(tips1)
    }
    
    //Any是所有类型的超类
    println(tips)
    
    
  }
  
}
