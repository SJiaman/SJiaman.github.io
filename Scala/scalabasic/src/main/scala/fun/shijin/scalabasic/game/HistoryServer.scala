package fun.shijin.scalabasic.game

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

class HistoryServer {

    var historyNum = 10
    var histories = ArrayBuffer(new HisttoryData(0,1))

    def list():ArrayBuffer[HisttoryData] = {
      this.histories
    }

    //添加历史战绩
    def add(score:Int):Boolean = {
      historyNum+=1
      var histories_test = new HisttoryData(score,historyNum)
      histories.append(histories_test)
      true
    }
  //删除历史战绩
  def del(times:Int):Boolean = {
    val index = findIndexById(times)
    if (index != -1){
      histories.remove(index)
      true
    }else{
      false
    }
  }

  //根据id找到index
  def findIndexById(times : Int) = {
    var index = -1 //默认-1,如果找到就改成对应,如果没有找到，就返回-1
    //遍历customers
    breakable {
      for (i <- 0 until histories.length) {
        if (histories(i).times == times) { //找到
          index = i
          break()
        }
      }
    }
    index
  }

    /*
    测试性添加数据
    */
    var temp0:Int=_
    for (i <- 2 to 10){
      var histories_test1 = new HisttoryData(new util.Random().nextInt(10),i)
      histories.append(histories_test1)
    }

}
