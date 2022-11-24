package fun.shijin.scalabasic.chapter05

import scala.util.control.Breaks._

/**
 * @Author shijin
 * @Date 2021/6/3 17:58
 * @Desc
 */

object Test {
  def main(args: Array[String]): Unit = {
    def loginFun(name:String, password:String, c:(String, String) => Boolean): Unit = {
      var i:Int = 0
//      while (i < 3) {
//        breakable() {
//          var bool = c(name, password)
//          i += 1
//          if (bool)
//            println("登录成功")
//          else break()
//        }
//      }
      
    }
    
    def check(name:String, password:String):Boolean = {
      var flag:Boolean = false
      if (name == "smalltiger" && password == "888") flag = true
      else flag = false
      flag
    }
  }
}
