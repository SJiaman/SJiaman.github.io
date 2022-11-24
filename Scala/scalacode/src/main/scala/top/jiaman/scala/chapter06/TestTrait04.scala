package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 13:54
 * @Desc 特质叠加  解决特质冲突(钻石问题)
 */

object TestTrait04 {
  def main(args: Array[String]): Unit = {
    val operation = new MyOperation
    println(operation.describe())
  }
}
trait Operation {
  def describe(): String = {
    "插入数据"
  }
}

trait DBOpreation extends Operation {
  override def describe(): String = {
    "向数据库中插入数据" + super.describe()
  }
}

trait HDFSOpreation extends Operation {
  override def describe(): String = {
    "向HDFS中插入数据" + super.describe()
  }
}

class MyOperation extends HDFSOpreation with DBOpreation {
  override def describe(): String = {
    "我都插入-->" + super.describe()
  }
}