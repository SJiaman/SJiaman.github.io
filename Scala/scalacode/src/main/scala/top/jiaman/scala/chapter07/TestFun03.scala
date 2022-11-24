package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/23 20:40
 * @Desc 集合计算的高级函数
 */

object TestFun03 {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    //（1）过滤 遍历一个集合并从中获取满足指定条件的元素组成一个新的集合
    //对List集合进行遍历，将偶数取出，放到新的集合中去
    println(list.filter((elem: Int) => {
      elem % 2 == 0
    }))
    println(list.filter( _ % 2 == 0))
  
    //（2）转化/映射（map） 将集合中的每一个元素映射到某一个函数
    println(list.map(_ * 2))
  
    //（3）扁平化   :::
    val nestedList : List[List[Int]]  = List(List(1,2,3),List(4,5,6),List(7,8,9))
    val newList: List[Int] = nestedList.flatten
    newList.foreach(println)
  
    //（4）扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作  集合中的每个元素的子元素映射到某个函数并返回新集合
  
    val strings: List[String] = List("hello atguigu","hello jingjing","banzhang jingjing")
    /*
    //对字符串使用空格进行分割，将分割后的单词放到一个新的集合中  List("hello","atguigu","hello","jingjing","banzhang","jingjing")

    //先对集合中的元素进行转换   字符串---->数组
    val splitList: List[Array[String]] = strings.map(_.split(" "))

    //将集合中的元素由整体 --->个体
    val flatList: List[String] = splitList.flatten

    //输出查看效果
    println(flatList)*/
  
    //使用flatMap函数完成上述功能
    val flatMapList: List[String] = strings.flatMap(_.split(" "))
    println(flatMapList)
  
    //（5）分组(groupBy) 按照指定的规则对集合的元素进行分组
    val list1: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val groupMap: Map[Int, List[Int]] = list1.groupBy(_%2)
    println(groupMap)
  
    val nameList: List[String] = List("jingjing","banzhang","banhua","xingda","jiafeng")

    val groupMap1: Map[Char, List[String]] = nameList.groupBy(_.charAt(0))
    println(groupMap1)
  }
}
