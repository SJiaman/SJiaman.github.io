package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/16 16:59
 * @Desc 在Scala中，函数是一等公民
 *       1）函数可以作为值进行传递
 *       2）函数可以作为参数进行传递
 *       3）函数可以作为函数返回值返回
 */
object TestFun07 {
  def main(args: Array[String]): Unit = {
    /*
    //（1）函数可以作为值进行传递
    def foo(): Int = {
      println("foo...")
      1
    }
    
    //（1）调用foo函数，把返回值给变量f
    val f = foo()
    
    //（2）在被调用函数foo后面加上 _，相当于把函数foo当成一个整体，传递给变量f1
    val f1 = foo _
    f1()
  
    //（3）如果明确变量类型，那么不使用下划线也可以将函数作为整体传递给变量
    var f2: () => Int = foo
    f2()
    */
    
    /*//2）函数可以作为参数进行传递
    // （1）定义一个函数，函数参数还是一个函数签名；f表示函数名称;(Int,Int)表示输入两个Int参数；Int表示函数返回值
    def ff(f: (Int, Int) => Int): Int = {
      f(2, 4)
    }
  
    // （2）定义一个函数，参数和返回值类型和f1的输入参数一致
    def add(a: Int, b: Int): Int = a + b
  
    // （3）将add函数作为参数传递给f1函数，如果能够推断出来不是调用，_可以省略
    println(ff(add))
    println(ff(add _))
    
    //采用匿名函数
    println(ff(
      (a: Int, b: Int) => a + b
    ))
    
    println(ff(_ + _))*/
    
    //3）函数可以作为函数返回值返回
    def f4() = {
      def f2() = {
        println("shijin")
      }
      
      f2 _
    }
    
    // 因为f1函数的返回值依然为函数，所以可以变量f可以作为函数继续调用
    val f = f4()
    
    f()
    // 上面的代码可以简化为
    f4()()
    
    
    def fa(x: Int) = {
      def fb(y: Int) = {
        def fc(): Int = {
          x + y
        }
        // 把fc整体赋值给fb
        fc _
      }
      
      fb _
    }
    
    println(fa(10)(20)())
    
    def fd(x: Int) = {
      def fe(y: Int) = {
        def fg(f: (Int, Int) => Int): Int = {
          f(x, y)
        }
        fg _
      }
      fe _
    }
    // (_ + _)为函数，表示两个变量相加，
    //(_ + _) = (a: Int, b: Int) => a + b
    println(fd(10)(20)(_ + _))
  }
}

