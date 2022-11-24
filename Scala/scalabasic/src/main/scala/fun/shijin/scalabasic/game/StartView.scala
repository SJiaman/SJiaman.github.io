package fun.shijin.scalabasic.game

import scala.io.StdIn

class StartView {
  //定义一个循环变量，控制是否退出while
  var loop = true
  //定义一个key用于接收用户输入的选项
  var key = " "
  val histor = new HistoryView() //不尽循环是保证历史数据的唯一性

  def mainMenu(): Unit = {
    do {
      println("-----------------消灭野怪------------------------")
      println("                 start   开始游戏                ")
      println("                 end     退出游戏                ")
      println("                 history 历史战绩                ")

      print("请输入相应的word：")
      key = StdIn.readLine()
      key match {
        case "start" => val play = new GameView()
          play.playgame(histor)

        case "history" => histor.mainMenu()

        case "end" => loop = false
          println("退出游戏程序")
        case _ => println("请确保输入是否合理：")
      }

    } while (loop)

  }


}
