package top.jiaman.scala.chapter07

import scala.collection.mutable

/**
 * @Author Jiaman
 * @Date 2021/1/23 20:09
 * @Desc Map集合
 */

object TestMap {
  def main(args: Array[String]): Unit = {
  
    //创建不可变map集合    底层就是HashMap
    val map: Map[String, Int] = Map("a"->1,"b"->2,"c"->3)

    println(map.getClass)
    //遍历map集合中的元素
    map.foreach((kv:(String,Int))=>{println(kv)})
    //map.foreach(println)

    //keys获取map集合中的所有key
    //values获取map集合中的所有value
    for (key <- map.keys) {
      println(key + "---->" + map.get(key))
    }

    println(map.get("a").get)  // Some(1)
    //在Scala语言中，为了避免空指针异常，如果获取的内容，有可能为空，可以用Option表示
    //println(map.get("d")) //None
    //println(map.get("d").getOrElse(0))
    println(map.getOrElse("a", 0))
  
  /*  //可变map集合
    val map: mutable.Map[String, Int] = mutable.Map("e"-> 1, "a" -> 1, "b" -> 2, "c" -> 3)
  
    //添加
    map.put("d", 4)
  
    //删除元素
    map.remove("d")
  
    //修改map集合中元素
    map.update("a", 20)
//    map("a") = 30
    map.foreach(println)*/
  }
}
