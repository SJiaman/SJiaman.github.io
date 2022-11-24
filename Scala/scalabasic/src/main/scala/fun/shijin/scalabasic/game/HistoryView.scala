package fun.shijin.scalabasic.game

import scala.io.StdIn

class HistoryView{

  var loop = true
  var key = " "
  val historyS = new HistoryServer()

  def mainMenu(): Unit = {
    println("------------------历史战绩------------------")
    println("时间\t\t分数")
    val histories = historyS.list()
    for (history <- histories)
      println(history)
    println("------------------历史战绩打印完毕----------")

    do {
      println("-----------------历史战绩查询-----------------")
      println("                 1 时间升序查询")
      println("                 2 时间降序查询")
      println("                 3 得分升序查询")
      println("                 4 得分降序查询")
      println("                 5 删除历史数据")
      //println("                 6 增加历史数据")
      println("                 0 退       出")
      print("请选择相应数字：")
      key = StdIn.readLine()

      key match {
        case "1" => this.ascTimeOrder()
        case "2" => this.desTimeOrder()
        case "3" => this.ascScoreOrder()
        case "4" => this.desScoreOrder()
        case "5" => this.delall()
        case "0" => this.loop = false
      }
      println("查询完毕！")
    }while(loop)


  }
  //1 时间升序查询
  def ascTimeOrder():Unit = {
    println("--------------历史战绩时间升序排序为---------------")
    val histories = historyS.list().sortWith((x,y)=>{
      x.times < y.times
    })
    for (history <- histories)
      println(history)

  }
  //2 时间降序查询
  def desTimeOrder():Unit = {
    println("--------------历史战绩时间降序排序为---------------")
    val histories = historyS.list().sortWith((x,y)=>{
      x.times > y.times
    })
    for (history <- histories)
      println(history)
  }
  //3 得分升序查询
  def ascScoreOrder():Unit = {
    println("--------------历史战绩得分升序排序为---------------")
    val histories = historyS.list().sortWith((x,y)=>{
      x.score < y.score
    })
    for (history <- histories)
      println(history)
  }
  //4 得分降序查询
  def desScoreOrder():Unit = {
    println("--------------历史战绩得分降序排序为---------------")
    val histories = historyS.list().sortWith((x,y)=>{
      x.score > y.score
    })
    for (history <- histories)
      println(history)
  }
  //5 删除历史数据
  def delall():Unit = {
    println("------------------删除历史数据--------------------")
    println("------------------输入需要删除的时间--------------")
    val times = StdIn.readInt()
    historyS.del(times)
  }
  //6 增加历史数据
  def add(score:Int):Unit = {
    println("-----------------添加历史数据成功-------------------")
    historyS.add(score)
  }

}


