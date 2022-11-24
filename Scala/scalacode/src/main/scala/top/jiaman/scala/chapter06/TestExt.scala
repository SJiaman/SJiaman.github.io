package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 14:13
 * @Desc
 * （1）obj.isInstanceOf[T]：判断obj是不是T类型。
 * （2）obj.asInstanceOf[T]：将obj强转成T类型。
 * （3）classOf获取对象的类名。
 * 枚举类：需要继承Enumeration
 * 应用类：需要继承App
 * 使用type关键字可以定义新的数据数据类型名称，本质上就是类型的一个别名
 */

class Person23{}
object TestExt {
  def main(args: Array[String]): Unit = {
    //创建一个Person23对象
    val per:Any = new String
    
    //判断per是否是Person23类型
    val res: Boolean = per.isInstanceOf[Person23]
    println(res)
    
    if(res){
      //将Any类型的对象per强转为Person23类型   注意：强转需要存在继承关系
      val p1: Person23 = per.asInstanceOf[Person23]
    }
    
    //获取类型的信息
    val clz: Class[Person23] = classOf[Person23]
    println(clz)
    
  }
}

// 应用类
object Test20 extends App {
  println("xxxxxxxxxxx");
  
  type MyS = String
  private val abc: MyS = "abc"
}

