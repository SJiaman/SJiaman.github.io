package top.jiaman.scala.chapter07

import scala.collection.mutable


/**
 * @Author Jiaman
 * @Date 2021/1/25 22:06
 * @Desc 队列
 */

object TestQueue {
  def main(args: Array[String]): Unit = {
    val que = new mutable.Queue[String]()

    que.enqueue("a", "b", "c")

    println(que.dequeue())
    println(que.dequeue())
    println(que.dequeue())
    
    //val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}
    //val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}
    
    //println(result1)
   // println(result2)
    
    
  }
}
