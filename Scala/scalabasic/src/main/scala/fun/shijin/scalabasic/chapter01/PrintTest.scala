package fun.shijin.scalabasic.chapter01

/**
 * @Author shijin
 * @Date 2021/5/6 9:35
 * @Desc
 */

object PrintTest {
  def main(args: Array[String]): Unit = {
    val name = "ZZZ"
    val age = 19
  
    // 字符串拼接
    println("name=" + name + ", age=" + age)
  
    // 占位符
    printf("name=%s,age=%d\n",name,age)
  
    // 插值字符串 $
    println(s"name=$name, age=$age")
  
    println(
      s"""
		name=$name
		age=$age
		""")
  }
}
