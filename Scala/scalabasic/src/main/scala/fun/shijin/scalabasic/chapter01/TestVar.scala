package fun.shijin.scalabasic.chapter01

/**
 * @Author shijin
 * @Date 2021/5/6 9:44
 * @Desc
 */

object TestVar {
  // 声明外部变量
  val name1:String = "java"
  val age1:Int = 19
  def main(args: Array[String]): Unit = {
  
    //声明内部变量 ， val 不可修改，var可修改
    var name: String = "zhangq"
    val age: Int = 19
  
    println(s"name=$name,age=$age")
  
    name = "python"
    println(name)
    
    // 声明age为Double类型
    val age2:Double = 19
    println(age2)
    
    // 不指定类型，自动推断类型
    var age3 = 19
    println(age3)
    
    val name4, age4 = 10
    
    println(name4 + age4)
    
  }
}
