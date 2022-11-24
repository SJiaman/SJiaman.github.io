package top.jiaman.scala.chapter04

import scala.io.StdIn

/**
 * @Author Jiaman
 * @Date 2021/1/9 20:57
 * @Desc
 */

object TestIf {
  def main(args: Array[String]): Unit = {
    /*
//-------单分支-------
println("请输入年龄")
val age: Int = StdIn.readInt()
if(age < 18){
  println("童年")
}

//-------双分支-------
println("请输入年龄")
val age: Int = StdIn.readInt()
if(age < 18){
  println("童年")
}else{
  println("成年")
}

//-------多分支-------
println("请输入年龄")
val age: Int = StdIn.readInt()
if(age < 18){
  println("童年")
}else if(18<=age && age<40){
  println("成年")
}else {
  println("老年")
}

//---------分支语句返回值----------
println("请输入年龄")
val age: Int = StdIn.readInt()
//分支语句是有返回值的，具体返回什么，和满足条件的分支语句块中的最后一行代码有关
val res: String = if(age < 18){
  "童年"
}else if(18<=age && age<40){
  "成年"
}else {
  "老年"
}
println(res)

//---------分支语句返回值   每个分支块返回的类型不一致----------
println("请输入年龄")
val age: Int = StdIn.readInt()
//如果每一个分支块返回的数据类型不一致，那么取它们共同的祖先类型
val res:Any = if(age < 18){
  "童年"
}else if(18<=age && age<40){
  "成年"
}else {
  100
}
println(res)
*/
    //案例：通过if...else 模拟三元运算符实现    res = 条件表达式?值1:值2
    println("请输入年龄")
    val age: Int = StdIn.readInt()
    //如果分支代码块中，只有一行代码，那么花括号可以省略
    var res = if (age < 18) "童年" else "成年"
    println(res);
  }
}
