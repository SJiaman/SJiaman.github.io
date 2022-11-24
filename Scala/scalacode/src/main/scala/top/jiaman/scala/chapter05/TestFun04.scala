package top.jiaman.scala.chapter05

/**
 * @Author Jiaman
 * @Date 2021/1/10 22:48
 * @Desc 函数的参数
 */

object TestFun04 {
  def main(args: Array[String]): Unit = {
    
    //（1）可变参数
    def f1(s: String*): Unit = {
      println(s)
    }
    //f1()  List()
    f1("aaa", "bbbb") //WrappedArray(aaa, bbbb)
    
    //在一个参数列表中，至多只能有一个可变长参数
    //（2）如果参数列表中存在多个参数，那么可变参数应该放置在最后
    //        def f2(s1: String, s2: String*): Unit = {
    //
    //        }
    //
    //        //（3）参数默认值，一般将有默认值的参数放置在参数列表的后面
    //        def f3(name: String = "atguigu"): Unit = {
    //            println(name)
    //        }
    //
    //        f3("banzhang")
    //
    //（4）带名参数
    //def f4(sex:String,name:String="jingjing"): Unit ={
    def f4(name: String = "jingjing", sex: String): Unit = {
      println(name + ":::" + sex)
    }
    //f4("banzhang","男")
    
    f4(sex = "nv", name = "lisi")
  }
  
}
