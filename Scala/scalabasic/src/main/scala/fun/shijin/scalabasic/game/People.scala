package fun.shijin.scalabasic.game

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class People {

  val prop0 : Prop = new Prop()
  var live:Boolean = true//角色状态
  var fron:Int = 201
  var left:Int = 202
  var right:Int = 203
  val backbug = mutable.Map( "水"->prop0, "火"->prop0, "金"->prop0 , "木"->prop0 , "土"->prop0 )//背包

  def this(live:Boolean,fron:Int,left: Int,right:Int,nature:String,prop:Prop){
    this
    this.live = live
    this.fron = fron
    this.left = left
    this.right = right
    this.backbug.update(nature,prop)
  }


  def updated(live:Boolean,fron:Int,left: Int,right:Int,nature:String,prop:Prop):Unit = {
    this.live = live
    this.fron = fron
    this.left = left
    this.right = right
    this.backbug.update(nature,prop)
  }
  def del(nature:String):Unit = {
    this
    this.backbug.update(nature,prop0)
  }

  override def toString:String = {
    this.live + "\t" + this.fron + "\t" + this.left + "\t" + this.right + "\t" + this.backbug
  }
}
