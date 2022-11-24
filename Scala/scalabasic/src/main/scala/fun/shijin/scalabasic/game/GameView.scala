package fun.shijin.scalabasic.game

import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.util.Random

class GameView {

  val people = new People()
  val mosterServer = new MosterServer()
  val propServer = new PropServer()
  var loop = true
  var key = " "
  var getScore = 0

  //随机设置角色周围的元素
  val list: List[Int] = List(101, 102, 103, 104, 105, 201, 202, 203, 204, 205, 0)//随机列表

  def playgame(historyView: HistoryView): Unit = {
    conlect(204)//开局先送一个“复苏木”武器
    //开始游戏
    do {
      println("---------------------消灭野怪游戏界面-----------------")
      println("---------------------w  向前一步    -----------------")
      println("---------------------a  向左一步    -----------------")
      println("---------------------d  向右一步    -----------------")
      println("---------------------0  退出游戏    -----------------")
      print("请输入相应的字母来移动角色：")
      key = StdIn.readLine()
      key match {
        case "w" => println("向前了一步")
          this.action(list, people.fron)
        case "a" => println("向左了一步")
          this.action(list, people.left)
        case "d" => println("向右了一步")
          this.action(list, people.right)
        case "0" => this.loop = false
          println("游戏结束！")
      }
      //随机情况
      people.fron = Random.shuffle(list).take(1)(0)
      people.left = Random.shuffle(list).take(1)(0)
      people.right = Random.shuffle(list).take(1)(0)

    } while (loop)
    println("很遗憾你挂了")
    historyView.add(getScore)
    println("本次游戏得分为：" + getScore)

  }

  def action(list: List[Int], peoplex: Int): Unit = {
    //判断向前一步所需动作
    getScore += 1 //每前进一部都加一分
    if (list.contains(peoplex)) {
      peoplex match {
        case 101 => playMoster(101) //打怪
        case 102 => playMoster(102)
        case 103 => playMoster(103)
        case 104 => playMoster(104)
        case 105 => playMoster(105)

        case 201 => conlect(201) //集道具
        case 202 => conlect(202)
        case 203 => conlect(203)
        case 204 => conlect(204)
        case 205 => conlect(205)

        case 0 => println("继续")
      }
    } else {
      println("继续")
    }
  }

  def playMoster(id: Int): Unit = {
    //打野怪
    val mosters = mosterServer.list() //野怪列表
    for (moster <- mosters)
      if (moster.id == id) {
        println(moster.name + "野怪登场，请尽快消灭它！")
        if (useProp() == moster.n_nature) {   //使用武器
          println("你击败野怪！")
          getScore += 1 //击败野怪另外加1分
          return
        } else {
          loop = false
          return
        }
      }
  }

  def useProp(): String = {
    println("------------------选择将要使用的武器---------------")
    println("----------------201 使用金宝缸")
    println("----------------202 使用水凝珠")
    println("----------------203 使用喷火枪")
    println("----------------204 使用复苏木")
    println("----------------205 使用腐化土")
    print("请输入相应的数字决定使用的武器：")
    val uset = StdIn.readInt()
    val list3 = ListBuffer(-10) //可变列表
    for (elem <- people.backbug.values) {
      list3.+=(elem.pid)  //将背包里的武器id放到list3
    }
    if (list3.contains(uset)) {  //判断背包是否有该道具
      uset match {
        case 201 => del("金")
          return "金"
        case 202 => del("水")
          return "水"
        case 203 => del("火")
          return "火"
        case 204 => del("木")
          return "木"
        case 205 => del("土")
          return "土"  //返回武器属性
      }
    }
    println("还未收集到该武器")
    return " "
  }

  //收集道具
  def conlect(id: Int): Unit = {
    println("---------------------收集武器----------------------")
    val props = propServer.list() //武器列表
    for (pro <- props) {
      if (pro.pid == id) {
        val pnatue = pro.pnature
        people.backbug.update(pnatue, pro) //更新背包武器  Map的修改
        println("收集了： " + pro.pname + " 武器！")
        println("----------背包里武器有：")
        val keys = people.backbug.keys
        //遍历背包武器
        println("属性----id-----名称-----属性")
        for (key <- keys){
          println(key + ": " + people.backbug.get(key))  //打印背包里面的内容
        }

        return
      }

    }
  }

  //删除道具
  def del(nature: String) = {
    people.del(nature)  //删除背包里被使用的武器
    println("----------背包里武器有：")
    val keys = people.backbug.keys
    //遍历背包武器
    println("属性----id-----名称-----属性")
    for (key <- keys){
      println(key + ": " + people.backbug.get(key))
    }

  }

}
