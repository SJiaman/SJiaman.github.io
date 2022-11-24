package fun.shijin.scalabasic.game

class Monster {
  //野怪信息
  var id:Int = _
  var name:String = _
  var nature:String = _     //拥有属性
  var n_nature:String = _   //被克属性

  //设计一个辅助构造器
  def this(id:Int,name:String,nature:String,n_nature:String){
    this
    this.id = id
    this.name = name
    this.nature = nature
    this.n_nature = n_nature
  }


  override def toString:String = {
    this.id + "\t\t" + this.name + "\t\t" + this.nature + "\t\t" + this.n_nature
  }
}
