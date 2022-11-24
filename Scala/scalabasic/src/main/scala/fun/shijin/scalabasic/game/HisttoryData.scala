package fun.shijin.scalabasic.game

class HisttoryData {
  var times:Int = _  //时间
  var score:Int = _  //分数

  def this(score:Int,times:Int = 10){
    this
    this.times = times
    this.score = score
  }
  def this(score:Int){
    this
    this.score = score
  }

  override def toString :String ={
    this.times + "\t\t" + this.score
  }
}
