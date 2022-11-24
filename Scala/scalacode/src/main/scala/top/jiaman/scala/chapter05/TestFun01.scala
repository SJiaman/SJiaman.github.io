package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/10 22:31
 * @Desc 函数定义
 */

object TestFun01 {
  def main(args: Array[String]): Unit = {
    
    // 定义函数
    def p(word: String): Unit = {
      print(word)
    }
    
    // 函数调用
    p("Jiaman is the best!")
  }
  
}
