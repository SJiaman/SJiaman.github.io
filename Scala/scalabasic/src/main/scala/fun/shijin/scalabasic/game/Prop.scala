package fun.shijin.scalabasic.game

class Prop {
  var pid:Int = _
  var pname:String = _
  var pnature:String = _  //武器属性

  def this(pid:Int,pname:String,pnature:String){
    this
    this.pid = pid
    this.pname = pname
    this.pnature = pnature
  }


  override def toString : String = {
    this.pid + "\t" + this.pname + "\t" + this.pnature
  }
}
