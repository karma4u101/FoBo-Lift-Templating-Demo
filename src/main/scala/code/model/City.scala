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


class City private() extends Record[City] with KeyedRecord[Long] with Loggable  {
  
  def meta = City
  
  @Column(name="id")
  override val idField = new LongField(this)	
  val country = new StringField(this,150)
  val region = new StringField(this,150)
  val cityName = new StringField(this,150)
  val population = new IntField(this)
}

object City extends City with MetaRecord[City] with Loggable {
  logger.debug("model.City obj start")
  
  def getAllList():List[City] = transaction {
    from(MySchema.city)(c => select(c)).toList
  } 
  
  def find(id: Int): Box[City] = {
    logger.debug("model.City object find id(string)="+id)
    val c = getAllList.find(_.id==id)
    logger.debug("model.City object find found ="+c.toString())
    c
  }  
  
  def unapply(id: Int): Option[City] = {
    logger.debug("model.City:unapply(id="+id+":Int) returns Option[City]")
    find(id)
  }
  
  def findCity(cityName: String): Box[City] = {
    logger.debug("model.City object findCity city(string)="+id)
    val c = getAllList.find(_.cityName.equals(cityName))
    logger.debug("model.City object findCity found ="+c.toString())
    c
  }
  
  def findRegion(region: String): Box[City] = {
    logger.debug("model.City object findRegion region(string)="+id)
    val c = getAllList.find(_.region.equals(region))
    logger.debug("model.City object findRegion found ="+c.toString())
    c
  }  
  
  def findCountry(country: String): Box[City] = {
    logger.debug("model.City object findCountry country(string)="+id)
    val c = getAllList.find(_.country.equals(country))
    logger.debug("model.City object findCountry found ="+c.toString())
    c
  }    
 
  logger.debug("model.City obj end")
}


