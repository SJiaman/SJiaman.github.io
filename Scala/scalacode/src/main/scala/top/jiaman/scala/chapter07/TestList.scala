package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/23 19:42
 * @Desc 不可变数组
 */

object TestList {
  def main(args: Array[String]): Unit = {
    //创建List集合,因为List是抽象的，只能通过apply方式创建
    val list: List[Int] = List(1, 2, 3, 4)
  
    //向集合中添加元素
//    val newList1: List[Int] = list.+:(10)
//    val newList1: List[Int] = list.:+(20)
//    println(newList1)
  
  
    //在Scala语言中个，List()===>Nil 表示空集合
//    val newList2: List[Int] = list.::(50)
    val newList2: List[Int] = Nil.::(40)
    println(newList2)
  
    val newList3: List[Int] = 10 :: 20 :: 30 :: 40 :: Nil
    println(list.getClass)
    println(list)
    println(newList3)
  
    //扁平化   将整体拆分为个体的过程
    val list2: List[Int] = List(1, 2, 3, 4)
    val list3: List[Int] = List(5, 6)
  
    //向集合中添加元素  ::
    val newList4: List[Any] = list2 :: list3
    println(newList4)
  
    val newList: List[Int] = list2 ::: list3
    println(newList)
  
    //获取集合中的某一个元素
    println(newList(1))
  
    newList.foreach(println)
  }
}
