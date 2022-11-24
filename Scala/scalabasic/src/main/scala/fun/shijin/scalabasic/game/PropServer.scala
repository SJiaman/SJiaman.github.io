package fun.shijin.scalabasic.game

import scala.collection.mutable.ArrayBuffer

class PropServer {
  var props = ArrayBuffer(new Prop(201,"金宝缸","金"))

  def list():ArrayBuffer[Prop] = {
    this.props
  }
  def add(prop: Prop):Boolean = {
    props.append(prop)
    true
  }
  //默认加入
  this.add(new Prop(202,"水凝珠","水"))
  this.add(new Prop(203,"喷火枪","火"))
  this.add(new Prop(204,"复苏木","木"))
  this.add(new Prop(205,"腐化土","土"))

}
