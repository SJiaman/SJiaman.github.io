package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/21 19:30
 * @Desc
 */

/*
  通过嵌套的方式声明包
    -一个源文件中，可以声明多个不同的包
    -子包中的类可以直接访问父包中的类，而不需要进行导包
*/

package aaa{
  //外层包中的类
  object Outer{
    var out:String = "Outer"
    def main(args: Array[String]): Unit = {
      //导包语句可以出现在程序的任意位置
      import aaa.bbb.ccc.Inner
      Inner
    }
  }
  package bbb{
    package ccc{
      //内层包中的类
      object Inner{
        var in:String = "Inner"
        def main(args: Array[String]): Unit = {
          Outer.out
        }
      }
    }
  }
}

package ddd{
  package eee{
    import aaa.bbb.ccc.Inner
    object Test03{
      def main(args: Array[String]): Unit = {
        Inner
        println(ss)
        mm()
      }
    }
  }
}

package object ddd{
  var ss:String = "banzhang"
  def mm(): Unit ={
    println("banzhang")
  }
}
