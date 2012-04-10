package code.snippet

import net.liftweb._
import util._
import common._
import http._
import Helpers._
import code.lib.{DataTablesH=>ctrl}

class DataTables extends StatefulSnippet with Loggable {

  lazy val ctrl = new ctrl()
  //val ccList:List[City]  = City.getAllList()
  
   def dispatch = {
     case "semiDynamicDT" => semiDynamicDT
  }
  
  def semiDynamicDT = {
       var on = S.attr("on") openOr "on: NOT DEFINED!?"
       var tableId = S.attr("tableId") openOr "tableId: NOT DEFINED!?"
       //var options = S.attr("options") openOr ""
    " *" #> ctrl.semiDynamicJS(on,tableId)
  }
  
}