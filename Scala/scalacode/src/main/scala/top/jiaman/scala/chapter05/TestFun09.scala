package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/16 19:23
 * @Desc 一个函数/方法在函数/方法体内又调用了本身，我们称之为递归调用
 */

object TestFun09 {
  def main(args: Array[String]): Unit = {
    println(dg(5))
  }
  
  /*
  // 阶乘
        // 递归算法
        // 1) 方法调用自身
        // 2) 方法必须要有跳出的逻辑
        // 3) 方法调用自身时，传递的参数应该有规律
        // 4) scala中的递归必须声明函数返回值类型

   */
  
  def dg(i: Int): Int = {
    if (i == 1)
      i
    else
      i * dg(i - 1)
  }
}
