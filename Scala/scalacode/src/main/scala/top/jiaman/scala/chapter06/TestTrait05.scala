package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 14:00
 * @Desc 特质自身类型
 *     1.实现了依赖注入的功能
 *     2.要求混入该特质的同时要混入特质自身类型
 */

object TestTrait05 {
  def main(args: Array[String]): Unit = {
  
  }
}

class User(var name:String,var age:Int)

trait TraitA3{
  def m1(): Unit ={
    println("m1")
  }
}

//和数据库打交道，完成用户CRUD
trait UserDao{
  //2.要求混入该特质的同时要混入特质自身类型
  //_:TraitA3=>
  //向数据库的用户表中插入一条数据
  def insert(user:User):Unit={
    println("insert into datab " + user.name)
  }
}

trait OrderDao{
  //向数据库的用户表中插入一条数据
  def insert(user:User):Unit={
    println("orderDao " + user.name)
  }
}

class UserControllor {
  //1.实现了依赖注入的功能
  //_:UserDao =>
  //可以注入多个
  _:UserDao with OrderDao=>
  def regist(user:User): Unit ={
    insert(user)
  }
}

//所有的java接口，都可以当做特质被混入
class MyClass21 extends UserDao with TraitA3 with Serializable {

}