package top.jiaman.scala.chapter04

/**
 * @Author Jiaman
 * @Date 2021/1/9 20:56
 * @Desc
 */

object TestFor {
  def main(args: Array[String]): Unit = {
    
    //对范围数据进行遍历   to
    //for(i:Int <- 1.to(10)){
    //在声明变量的时候，类型可以省略，因为编译器根据集合中的数据，推导出变量类型
    //           for(i <- 1 to 10){
    //             print(i)
    //           }
    //对范围数据进行遍历   until
    //           for( i <- 1 until 10){
    //             println(i) //没有10
    //           }
    //在Scala语言中，没有contine和break关键字
    //通过if判断模拟continue跳出本次循环功能
    //           通过调用方法模拟break跳出整个循环功能
    //           for( i <- 1 to 5){
    //             if(i != 3){
    //               println(i)
    //             }
    //           }
    //           //循环守卫
    //           for( i <- 1 to 5; if i != 3){
    //             println(i)
    //           }
    //循环步长    对1到10中所有的奇数进行遍历
    //           for( i<- 1.to(10).by(2)){
    //           for( i<- 1 to 10 by 3){
    //           for( i<- 1.0 to 10.0 by 0.3){
    
    //
    //           for( i <- 1 to 20 by 2){
    //            println(i)
    //        }
    
    //           //循环嵌套
    //           for( i <- 1 to 3){
    //             for( j <- 1 to 3){
    //               println("i=" + i + ",j=" + j)
    //             }
    //           }
    //           for(i <- 1 to 3 ; j <- 1 to 3){
    //               println("i=" + i + ",j=" + j)
    //           }
    
    
    //循环引入变量
    //           for{
    //                i <- 1 to 5 ;
    //                j = 10 - i
    //           }{
    //             println("i=" + i + ",j=" + j)
    //           }
    
    
    //在Scala语言中，如果要打印多次字符串的话，可以    字符串*次数
    //        println("hello" * 5)
    
    //练习2：打印九层妖塔(等腰三角形)，要求：不能使用循环嵌套，用一层循环搞定
    //          *
    //         ***
    //        *****
    //       *******
    //
    //        for(i <- 1 to 9){
    //         println(" " * (-i+9) + "*" * (2*i-1))
    //        }
    //
    //        for(i <- 1 to 18 by 2;j = (18-i)/2){
    //
    //          println(" " * j +  "*" * i)
    //        }
    ////        //练习1：打印九九乘法表
    //        for(i<- 1 to 9){
    //          for(j <- 1 to i){
    //            print(s"${j} * ${i} = ${i*j} \t")
    //          }
    //          //外层循环控制 行数
    //          println()
    //        }
    //        for(i<- 1 to 9; j <- 1 to i){
    //          print(s"${j} * ${i} = ${i*j} \t")
    //          if(i == j){
    //            println()
    //          }
    //        }
    //
    //        //循环返回值
    //        //val res: immutable.IndexedSeq[Int] = for(i <- 1 to 5) yield i
    //
    //        //在原来集合元素的基础上*2，放到新的集合中去
    //        //val res: immutable.IndexedSeq[Int] = for(i <- 1 to 5) yield i * 2
    //        val res: immutable.IndexedSeq[Int] = for(i <- 1 to 5) yield {
    //          i * 2
    //        }
    //        println(res)
    //
    //        //倒序打印   底层调用的是reverse方法
    //        for(i <- 1 to 5 reverse){
    //          println(i)
    //        }
    //
    //        //while
    //        var a:Int = 5
    //        while (a >=1){
    //          println("zy  gj btk")
    //          a -= 1
    //        }
    //
    //        //do...while
    //        var a:Int = 0
    //        do{
    //          println("zy  gj btk")
    //          a -= 1
    //        }while(a >=1)
    //
  }
  
}
