package top.jiaman.scala.chapter02

/**
 * @Author Jiaman
 * @Date 2020/11/6 23:05
 * @Desc
 */

object TestString {
  def main(args: Array[String]): Unit = {
    //（1）字符串，通过+号连接
    var name: String = "jingjing"
    var age: Int = 18
    //println(age + "岁的"+ name +"在200105班级学习")
    println(s"${age}岁的${name}在200105班级学习")
    
    //（2）printf用法：字符串，通过%传值。
    //printf("%d岁的%s在200105班级学习",age,name)
    
    //（3）字符串模板（插值字符串）：通过$获取变量值
    // 保持字符串原格式显示与输出
    var sql: String =
    s"""
       |select
       |	*
       |from
       |  student
       |where
       |	name = ${name}
       |and
       |	age = ${age}
      """.stripMargin
    
    println(sql)
    
    val hei = 2.345
    println(f"The height is ${hei % 2.2f}")
    
    
  }
}
