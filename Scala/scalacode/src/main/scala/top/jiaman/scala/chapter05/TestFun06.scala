package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/13 19:56
 * @Desc 匿名函数
 *       （1）参数的类型可以省略，会根据形参进行自动的推导
 *       （2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号。
 *       （3）匿名函数如果只有一行，则大括号也可以省略
 *       （4）如果参数只出现一次，则参数省略且后面参数可以用_代替
 */

object TestFun06 {
  def main(args: Array[String]): Unit = {
    /* def f(s: String): Unit = {
         println(s)
     }

     def f1(f: (String)=>Unit): Unit = {
         f("shijin")
     }

     f1(f)
     f1((s: String)=>{println(s)})*/
    
    //定义一个函数：参数包含数据和逻辑函数
    def opreation(arr: Array[Int], op: Int => Int) = {
      for (elem <- arr) yield op(elem)
      
    }
    
    //定义逻辑函数
    def op(ele: Int): Int = {
      ele + 1
    }
    
    //标准函数调用
    val arr = opreation(Array(1, 2, 3, 4), op)
    println(arr.mkString(","))
    
    //匿名函数
    val arr1 = opreation(Array(1, 2, 3, 4), (ele: Int) => {
      ele + 1
    })
    println(arr1.mkString(","))
    
    //（1）参数的类型可以省略，会根据形参进行自动的推导
    val arr2 = opreation(Array(1, 2, 3, 4), (ele) => {
      ele + 1
    })
    println(arr2.mkString(","))
    
    //（2）类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号。
    val arr3 = opreation(Array(1, 2, 3, 4), ele => {
      ele + 1
    })
    println(arr3.mkString(","))
    
    //（3）匿名函数如果只有一行，则大括号也可以省略
    val arr4 = opreation(Array(1, 2, 3, 4), ele => ele + 1)
    println(arr4.mkString(","))
    
    //（4）如果参数只出现一次，则参数省略且后面参数可以用_代替
    val arr5 = opreation(Array(1, 2, 3, 4), _ + 1)
    println(arr5.mkString(","))
  
    //传递的函数有两个参数
    def calculator(a: Int, b: Int, op: (Int, Int) => Int): Int = {
      op(a, b)
    }
  
    // （1）标准版
    println(calculator(2, 3, (x: Int, y: Int) =>  {x + y}))
  
    // （2）如果只有一行，则大括号也可以省略
    println(calculator(2, 3, (x: Int, y: Int) =>  x + y))
  
    // （3）参数的类型可以省略，会根据形参进行自动的推导;
    println(calculator(2, 3, (x , y) =>  x + y))
  
    // （4）如果参数只出现一次，则参数省略且后面参数可以用_代替
    println(calculator(2, 3,   _ + _))
  
  }
  
}
