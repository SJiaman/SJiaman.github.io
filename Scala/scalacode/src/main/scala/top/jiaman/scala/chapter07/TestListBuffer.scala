package top.jiaman.scala.chapter07

import scala.collection.mutable.ListBuffer

/**
 * @Author Jiaman
 * @Date 2021/1/23 19:59
 * @Desc 可变list
 */

object TestListBuffer {
  def main(args: Array[String]): Unit = {
    //创建可变集合对象
    //val list: ListBuffer[Int] = new ListBuffer[Int]()
    val list: ListBuffer[Int] = ListBuffer(1,2,3)
    
    //向集合中添加元素  建议：可变用方法，不可变用符号
    list.append(10)
    list.insert(1,20)
    
    //修改元素
    list(0) = 30
    list.update(0,30)
    
    //删除
    list.remove(1,2)
    println(list)
  }
}
