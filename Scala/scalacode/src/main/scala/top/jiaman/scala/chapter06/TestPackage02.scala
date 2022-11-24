package top.jiaman.scala.chapter06

//import java.util.{ArrayList=>AL,_}
//import java.sql.{Date=>DD}
/**
 * @Author Jiaman
 * @Date 2021/1/21 19:32
 * @Desc 导包
 * 1）和Java一样，可以在顶部使用import导入，在这个文件中的所有类都可以使用。
 * 2）局部导入：什么时候使用，什么时候导入。在其作用范围内都可以使用
 * 3）通配符导入：import java.util._
 * 4）给类起名：import java.util.{ArrayList=>JL}
 * 5）屏蔽类：import java.sql.{Date=>_,Array=>_,_}
 * 6）导入相同包的多个类：import java.util.{HashSet, ArrayList}
 * 7）导入包的绝对路径：new _root_.java.util.HashMap
 */
object Scala04_TestPackage {
  def main(args: Array[String]): Unit = {
    //new Date
    //new AL
    new java.sql.Date(200)
    new _root_.java.util.HashMap
  }
  
  /*def m1(): Unit ={
    import java.sql.Date
    new Date(2000)
  }*/
}

/*package java{
  package util{
    class HashMap{}
  }
}*/
