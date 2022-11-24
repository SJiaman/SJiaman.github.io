package top.jiaman.scala.chapter07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * @Author Jiaman
 * @Date 2021/1/23 13:37
 * @Desc
 *      可变数组，在执行添加或者删除操作的时候，不会创建新的数组对象，直接在源数组上进行操作
 */

object TestArrayBuffer {
  def main(args: Array[String]): Unit = {
    //（1）创建并初始赋值可变数组
    val arr01 = ArrayBuffer[Any](1, 2, 3)
  
    //（2）遍历数组
    for (i <- arr01) {
      println(i)
    }
    println(arr01.length) // 3
    println("arr01.hash=" + arr01.hashCode())
  
    //（3）增加元素
    //（3.1）追加数据
    arr01.+=(4)
    //（3.2）向数组最后追加数据
    arr01.append(5,6)
    //（3.3）向指定的位置插入数据
    arr01.insert(0,7,8)
    println("arr01.hash=" + arr01.hashCode())
  
    //（4）修改元素
    arr01(1) = 9 //修改第2个元素的值
    println("--------------------------")
  
    for (i <- arr01) {
      println(i)
    }
    println(arr01.length) // 5
  
  
    //向数组中添加元素    建议：在操作集合的时候，不可变用符号，可变用方法
    //val newArr = arr. += (20)
    //arr.append(30)
    //arr.insert(1,50)
  
    //注意：并不是数组是可变的，在操作数组对象的时候，就不能创建新的数组对象了。  也可以调用相关的方法，去创建新的对象
    //val newArr: ArrayBuffer[Int] = arr.+:(30)
    //println(arr.mkString(","))
    //println(newArr.mkString(","))
  
    //删除数组中的元素
    //val num: Int = arr.remove(1)
    //println(num)
  
    //arr.remove(1,2)
    //println(arr.mkString(","))
  
  
    //可变数组转换为不可变数组
    val arr: ArrayBuffer[Int] = ArrayBuffer(1,2,3)
    val newArr: Array[Int] = arr.toArray
  
    //不可变数组转换为可变数组
    val buffer: mutable.Buffer[Int] = newArr.toBuffer
  }
}
