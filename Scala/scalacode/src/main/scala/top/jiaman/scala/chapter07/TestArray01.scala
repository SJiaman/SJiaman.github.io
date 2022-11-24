package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/23 12:25
 * @Desc 数组练习
 *      不可变数组，所以在执行添加或者删除操作的时候，会创建新的数组对象
 */

object TestArray01 {
  def main(args: Array[String]): Unit = {
    //创建不可变数组
    val arr: Array[Int] = new Array[Int](5)
    
    arr(1) = 10
    //以方法形式改变数组元素
    arr.update(1, 100)
    println(arr(1))
    
    //1.普通for循环
    /* for (i <- 0 until arr.length) {
       println(arr(i))
     }
     
     for (elem: Int <- arr) {
       println(elem)
     }*/
    
    //2.迭代器
    /* val it: Iterator[Int] = arr.iterator
     while (it.hasNext) {
       println(it.next())
     }*/
    
    //3.增强for循环，
   /* arr.foreach((elem: Int) => {
      println(elem)
    })
    arr.foreach(println(_))
    arr.foreach(println)*/
    
    //用指定的字符串连接数组元素，形成一个新的字符串
    println(arr.mkString("--"))
    
    //向数组中添加元素
    //因为Array是不可变数组，所以在执行添加操作的时候，会创建新的数组对象
//    val newArr: Array[Int] = arr. +: (30)
//    println(newArr.mkString(","))
  
  
    //在Scala语言中，如果运算符方法中包含冒号，并且冒号在后，运算顺序为从右到左
    //val newArr: Array[Int] = arr +: 30  //编译报错
    
    val newArr: Array[Int] = 30 +: arr
    println(newArr.mkString(","))
  }
}
