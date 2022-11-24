package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/23 20:24
 * @Desc 元组
 */

object TestTuple {
  def main(args: Array[String]): Unit = {
    //创建元组对象
    //数据类型    ：Int\String\(参数类型)=>返回值类型\ =>(返回值类型) \ (类型...)
    val tuple: (String, String, Int) = ("100","jingjing",18)
    val tuple1: (String, Int) = ("shijin", 19)
    //访问元组中的数据
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
  
    //通过索引访问数据
    println(tuple1.productElement(1))
  
    //通过迭代器访问数据
    for (elem <- tuple.productIterator) {
      println(elem)
    }
  
    //Map集合中的键值对其实就是一种特殊的元组，元组中元素的个数是2个，我们称之为对偶元组
    val map1: Map[String, Int] = Map("a"->1,"b"->3)
    val map2: Map[String, Int] = Map(("a",1),("b",2))
    println(map1)
    println(map2)
  }
}
