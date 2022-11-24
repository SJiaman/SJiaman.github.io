package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/25 21:44
 * @Desc 单词计数：将集合中出现的相同的单词，进行计数，取计数排名前三的结果
 */

object TestWordCount {
  def main(args: Array[String]): Unit = {
    //简单版本
    // 需求：单词计数，将集合中出现的相同的单词，进行计数，取计数排名前三的结果
    val stringList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")

    //对集合中的字符串进行切割，切割之后形成一个字符串数组，对其进行扁平化处理
    val wordList: List[String] = stringList.flatMap(_.split(" "))

    //将相同的单词放到一组  Map(Hello -> List(Hello, Hello, Hello, Hello))
    val groupMap: Map[String, List[String]] = wordList.groupBy(elem=>elem)

    //对分组后map集合中的内容进行结构的转换   Map(Hello->4)
    //注意：map里面的函数参数是一个元素，不要误认为是两个参数
    val countMap: Map[String, Int] = groupMap.map(kv => {
      (kv._1, kv._2.size)
    })

    //排序  取前3   List((Hello,4), (Hbase,2), (kafka,1), (Scala,3))
    //val sortList: List[(String, Int)] = countMap.toList.sortBy(_._2)
    val sortList: List[(String, Int)] = countMap.toList.sortWith(_._2 > _._2).take(3)

    println(sortList)

    
   /*
    //复杂版本  方式1
    val tupleList = List(("Hello Scala Spark World ", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))
    
    //将元组(字符串，次数)  进行转换为一个大的字符串
    val newList: List[String] = tupleList.map(
      kv => {
        (kv._1.trim + " ") * kv._2
      }
    )
    //扁平映射
    val flatList: List[String] = newList.flatMap(_.split(" "))
    println(flatList)*/
  }
}
