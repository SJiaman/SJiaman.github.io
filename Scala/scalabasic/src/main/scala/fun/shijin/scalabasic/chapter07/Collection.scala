package fun.shijin.scalabasic.chapter07


import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
 * @Author shijin
 * @Date 2021/7/15 23:06
 * @Desc
 */

object Collection {
  def main(args: Array[String]): Unit = {
    // 1.List
    
    //1.1不可变List
    //创建List:nil
    val list = List(1,"2",3,'4')
    val list2=Nil
    // list 类型：List【any】
    
    // 遍历
    list.foreach(println)
    println(list)
    println(list2)
    
    // 增加数据【1】：+【】+：【】：：
    // :+在集合后面加元素
    var list3 = list:+5
    println(list3)
    
    // +：
    var list4 = 0+:list
    println(list4)
    
    // ::
    var list5=0::list3::list4
    println(list5)
    
    // 取指定数据:地标从0开始，//合并集合的元素是集合则该集合认为是一个底标
    println(list5(1))
    
    // 2. 创建一个可变集合List
    val buffer = ListBuffer(1,2,3,4)
  
    // 向集合中添加数据
    buffer.+=(5)
  
    // 打印集合数据
    buffer.foreach(println)
  
    // 2.Set
    
    // 2.1 Set默认是不可变集合，数据无序
    val set = Set(1,2,3,4,5,6)
    // 数据不可重复
    val set1 = Set(1,2,3,4,5,6,3)
    // 遍历集合
    for(x<-set1){
      println(x)
    }
  
    // 2.2创建可变集合Set
    val set2 = mutable.Set(1,2,3,4,5,6)
    // 集合添加元素
    set2 += 8
    // 向集合中添加元素，返回一个新的Set
    val ints = set2.+(9)
    println(ints)
    println("set2=" + set2)
    // 删除数据
    set2-=(5)
    // 打印集合
    set2.foreach(println)
    println(set2.mkString(","))
  
  
    // 3.Map
    // 3.1创建不可变集合Map
    val map = Map( "a"->1, "b"->2, "c"->3 )
    // 访问数据
    for (elem <- map.keys) {
      // 使用get访问map集合的数据，会返回特殊类型Option(选项):有值（Some），无值(None)
      println(elem + "=" + map.get(elem).get)
    }
    // 如果key不存在，返回0
    println(map.get("d").getOrElse(0))
    println(map.getOrElse("d", 0))
    // 循环打印
    map.foreach((kv)=>{println(kv)})
  
  
    // 3.2创建可变集合Map
    val map2 = mutable.Map( "a"->1, "b"->2, "c"->3 )
    //（3）向集合增加数据
    map2.+=("d"->4)
    // 将数值4添加到集合，并把集合中原值1返回
    val maybeInt: Option[Int] = map2.put("a", 4)
    println(maybeInt.getOrElse(0))
    //（4）删除数据
    map2.-=("b", "c")
    //（5）修改数据
    map2.update("d",5)
    //（2）打印集合
    map2.foreach((kv)=>{println(kv)})
    
  
    // 集合常用函数——初级
    val list11: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    //（1）获取集合长度
    println(list11.length)
    //（2）获取集合大小
    println(list11.size)
    //（3）循环遍历
    list11.foreach(println)
    //（4）迭代器
    for (elem <- list11.iterator) {
      println(elem)
    }
    //（5）生成字符串
    println(list11.mkString(","))
    //（6）是否包含
    println(list11.contains(3))
  
    // 集合常用函数——高级1
    val list21: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    val list22: List[Int] = List(4, 5, 6, 7, 8, 9, 10)
    //（1）获取集合的头
    println(list21.head)
    //（2）获取集合的尾（不是头的就是尾）
    println(list21.tail)
    //（3）集合最后一个数据
    println(list21.last)
    //（4）集合初始数据（不包含最后一个）
    println(list21.init)
    //（5）反转
    println(list21.reverse)
    //（6）取前（后）n个元素
    println(list21.take(3))
    println(list21.takeRight(3))
    //（7）去掉前（后）n个元素
    println(list21.drop(3))
    println(list21.dropRight(3))
    //（8）并集
    println(list21.union(list22))
    //（9）交集
    println(list21.intersect(list22))
    //（10）差集
    println(list21.diff(list22))
    //（11）拉链 注:如果两个集合的元素个数不相等，那么会将同等数量的数据进行拉链，多余的数据省略不用
    println(list21.zip(list22))
    //（12）滑窗
    list21.sliding(2, 5).foreach(println)
  
    // 集合常用函数——高级2
    val list33: List[Int] = List(1, 5, -3, 4, 2, -7, 6)
    //（1）求和
    println(list33.sum)
    //（2）求乘积
    println(list33.product)
    //（3）最大值
    println(list33.max)
    //（4）最小值
    println(list33.min)
    //（5）排序
    // （5.1）按照元素大小排序
    println(list33.sortBy(x => x))
    // （5.2）按照元素的绝对值大小排序
   
   
    println(list33.sortBy(x => x.abs))
    // （5.3）按元素大小升序排序
    println(list33.sortWith((x, y) => x < y))
    // （5.4）按元素大小降序排序
    println(list33.sortWith((x, y) => x > y))
  
  
    // 集合常用函数——高级3
    val list44: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val wordList: List[String] = List("hello world", "hello java", "hello scala")
    //（1）过滤
    println(list44.filter(x => x % 2 == 0))
    //（2）转化/映射
    println(list44.map(x => x + 1))
    //（3）扁平化
    println(nestedList.flatten)
    //（4）扁平化+映射 注：flatMap相当于先进行map操作，在进行flatten操作
    println(wordList.flatMap(x => x.split(" ")))
    //（5）分组
    println(list44.groupBy(x => x % 2))
    
  }
}
