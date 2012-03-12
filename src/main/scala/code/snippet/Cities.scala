package code.snippet

import net.liftweb._
import util._
import common._
import http._
import Helpers._
import code.model._

class Cities extends StatefulSnippet with Loggable {

  val ccList:List[City]  = City.getAllList()
  
  
   def dispatch = {
     case "simple" => simple
//     case "myJson" = myJson
  }
  
  def myJson = {
    
  }
  
  def simple = {
    "tbody *" #> ( ccList.map(c =>
      ".id *" #> c.id &
//      "id [class]+" #> "display:none" &
      ".country *" #> c.country &
      ".region *" #> c.region & 
      ".cityName *" #> c.cityName &
      ".population *" #> c.population &
      ClearClearable
      )
    )
  }
  
}