package top.jiaman.scala.chapter07

import scala.collection.mutable

/**
 * @Author Jiaman
 * @Date 2021/1/24 21:42
 * @Desc 对两个map集合之间的数据进行合并
 */

object TestFun05 {
  def main(args: Array[String]): Unit = {
    
    val map1 = mutable.Map("a"->1, "b"->2, "c"->3)
    
    val map2 = mutable.Map("a"->4, "b"->5, "d"->6)
    
    //最终合并后的效果  Map("a"->5,"b"->7,"c"->3,"d"->6)
    
    //技术选型：两个集合之间合并不属于集合内部元素聚合，所以fold更合适有些
    
    /*
    val res: mutable.Map[String, Int] = map1.foldLeft(map2) {
      //mm表示map2,kv表示map1中的每一个元素
      (mm, kv) => {
        //指定合并规则
        val k: String = kv._1
        val v: Int = kv._2
        //根据map1中元素的key，到map2中获取value
        mm(k) = mm.getOrElse(k, 0) + v
        mm
      }
    }
    println(res)
*/
    
    val res: mutable.Map[String, Int] = map2.foldLeft(map1) {
      (mm, kv) => {
        val k: String = kv._1
        val v: Int = kv._2
        mm(k) = mm.getOrElse(k, 0) + v
        mm
      }
    }
    println(res)
  }
}
