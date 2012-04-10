package code
package model

import net.liftweb._
import common._
import util._
import org.squeryl.annotations.Column
import net.liftweb.record._
import net.liftweb.record.field._
import net.liftweb.squerylrecord.KeyedRecord
import net.liftweb.squerylrecord.RecordTypeMode._


class REngine private() extends Record[REngine] with KeyedRecord[Long] with Loggable  {
  
  def meta = REngine
  
  @Column(name="id")
  override val idField = new LongField(this)	
  val engine = new StringField(this,150)
  val browser = new StringField(this,150)
  val platform = new StringField(this,150)
  val version = new StringField(this,150)
  val grade = new StringField(this,150)
}

object REngine extends REngine with MetaRecord[REngine] with Loggable {
  logger.debug("model.City obj start")
  
  def getAllList():List[REngine] = transaction {
    from(MySchema.rengine)(c => select(c)).toList
  } 
  
  def find(id: Int): Box[REngine] = {
    logger.debug("model.REngine object find id(string)="+id)
    val c = getAllList.find(_.id==id)
    logger.debug("model.REngine object find found ="+c.toString())
    c
  }  
  
//  def unapply(id: Int): Option[REngine] = {
//    logger.debug("model.REngine:unapply(id="+id+":Int) returns Option[REngine]")
//    find(id)
//  }
//  
//  def findCity(cityName: String): Box[REngine] = {
//    logger.debug("model.REngine object findCity city(string)="+id)
//    val c = getAllList.find(_.cityName==cityName)
//    logger.debug("model.REngine object findCity found ="+c.toString())
//    c
//  }
//  
//  def findRegion(region: String): Box[REngine] = {
//    logger.debug("model.REngine object findRegion region(string)="+id)
//    val c = getAllList.find(_.region==region)
//    logger.debug("model.REngine object findRegion found ="+c.toString())
//    c
//  }  
//  
//  def findCountry(country: String): Box[REngine] = {
//    logger.debug("model.REngine object findCountry country(string)="+id)
//    val c = getAllList.find(_.country==country)
//    logger.debug("model.REngine object findCountry found ="+c.toString())
//    c
//  }    
 
  logger.debug("model.REngine obj end")
}


