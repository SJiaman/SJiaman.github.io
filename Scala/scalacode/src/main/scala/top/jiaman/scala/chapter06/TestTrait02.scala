package top.jiaman.scala.chapter06

/**
 * @Author Jiaman
 * @Date 2021/1/22 11:25
 * @Desc 类与特质
 */

object TestTrait02 {
  def main(args: Array[String]): Unit = {
    /*
    var std1:MyStudent18 = new MyStudent18
    std1.run()
    std1.speak()
    */
    
    //特质的动态混入  ,在创建对象的时候，为该对象单独的混入某个特质
    //val stdBZ : MyStudent18 with TraitBuyBJP with TraitRap = new MyStudent18 with TraitBuyBJP with TraitRap {
    val stdBZ  = new MyStudent18 with TraitBuyBJP with TraitRap {
      override def buy(): Unit = {
        println("banzhang bjp")
      }
      
      override def rap(): Unit = {
        println("吃完保健品，来段rap")
      }
    }
    stdBZ.buy
    stdBZ.rap
    stdBZ.run()
    stdBZ.speak()
    
    
  }
}

trait TraitA{
  def run():Unit
}

trait TraitB{
  def speak():Unit
}

trait TraitBuyBJP{
  def buy():Unit
}

trait TraitRap{
  def rap():Unit
}

class Super18{}

//如果不存在继承关系，混入多个特质
//class MyClass18 extends TraitA with TraitB{}

//如果存在继承关系，同时混入特质
//先继承类，再混入特质
class MyStudent18 extends Super18 with TraitA with TraitB {
  override def run(): Unit = {
    println("jingjing run")
  }
  
  override def speak(): Unit = {
    println("jingjing speak")
  }
}