package fun.shijin.scalabasic.game

import scala.collection.mutable.ArrayBuffer

class MosterServer {

  var mosters = ArrayBuffer(new Monster(101,"风水龙","水","金"))//可变数组
  def list():ArrayBuffer[Monster] = {
    this.mosters
  }

  //添加野怪
  def add(monter:Monster):Boolean = {
    mosters.append(monter)
    true
  }

  //默认添加野怪
    this.add(new Monster(102,"火霸王","火","水"))
    this.add(new Monster(103,"木木怪","木","火"))
    this.add(new Monster(104,"盾土怪","土","木"))
    this.add(new Monster(105,"金角兽","金","土"))
}
