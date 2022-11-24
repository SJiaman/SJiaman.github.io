package top.jiaman.scala.chapter07

/**
 * @Author Jiaman
 * @Date 2021/1/23 20:37
 * @Desc 集合的初级函数
 */

object TestFun02 {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(5,1,8,2,-3,4)
    //（1）求和
    println(list.sum)
    //（2）求乘积
    println(list.product)
    //（3）最大值
    println(list.max)
    //（4）最小值
    println(list.min)
    //（5）排序     sorded|sortBy|sortWith
    println(list.sorted.reverse)
  
  
    //如果函数参数和函数体是一致的情况，那么不能简化
    //println(list.sortBy(elem => elem))
  
    //按照集合中元素的绝对值进行排序
    //println(list.sortBy(elem => elem.abs))
    //println(list.sortBy(_.abs))
    //println(list.sortBy(elem => elem).reverse)
    println(list.sortBy(elem => -elem))
  
    //println(list.sortWith((a:Int,b:Int)=>{a < b}))
    println(list.sortWith(_ > _))
  
  }
}
