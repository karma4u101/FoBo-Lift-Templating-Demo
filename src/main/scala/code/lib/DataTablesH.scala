package code.lib

import _root_.net.liftweb._
import util.{ Props }
import http._
import common._
import net.liftweb.http._
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmd
import net.liftweb.json._
import net.liftweb.json.JsonDSL._
import code.model._


class DataTablesH extends Loggable {
 
  
  def semiDynamicJS(on:String,tableId:String):scala.xml.Node = {
     var sc = JsRaw("""
     $(document).ready(function() {
       $('%s').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="%s"></table>' );
       $('#%s').dataTable( 
         %s
         );   
     } );           
     """.format(on,tableId,tableId,aaTColsAndTData() )).cmd
     JsCmds.Script(sc)
  }   
  def aaTColsAndTData() = pretty(render(buildData()))
  
    // In method below we are to build the following json structure
    // {
    //    "option":oval,....
    //    "aaData": [ 
    //        ['Trident','Internet Explorer 4.0','Win 95+','4','X'],
    //        ['Other browsers','All others','-','-','U']
    //          ],
    //    "aoColumns": [
    //        { "sTitle": "Engine" },
    //        { "sTitle": "Browser" },
    //        { "sTitle": "Platform" },
    //        { "sTitle": "Version", "sClass": "center" },
    //        { "sTitle": "Grade", "sClass": "center",
    //            "fnRender": function(obj) {
    //                var sReturn = obj.aData[ obj.iDataColumn ];
    //                if ( sReturn == "A" ) {
    //                    sReturn = "<b>A</b>";
    //                }
    //                return sReturn;
    //            }
    //        }
    //          ]  
    // }  
    // however there are currently a problem with the fnRender part as
    // the function(obj) block is string quoted i.e we get 
    // "fnRender": " function(obj) {...}"
    // instead of 
    // "fnRender":  function(obj) {...}
    // How do we solve it ?  
  def buildData():JObject = {
    ("bJQueryUI" -> true)  ~
    ("sPaginationType" -> "full_numbers") ~
    ("aaData" ->
      rengineData.map { t => 
        t.row 
      }
    ) ~
    ("aoColumns" -> //aoColumns
      columns.map {c => 
        ("sTitle" -> c.sTitle.map(_.title)  ) ~
        ("sClass" -> c.sClass.map(_.cd)  ) ~
        ("fnRender" -> c.fnRender.map(_.fn))
      }  
    ) 
  }
  private case class aaDT(row:List[String])
  private case class sTitle(title:String)                    
  private case class sClass(cd:String)
  private case class fnRender(fn:String)
  private case class aoCol(sTitle:Option[sTitle],sClass:Option[sClass],fnRender:Option[fnRender])   
  private val highlightA = { JsRaw(""" function(obj) {
                                        var sReturn = obj.aData[ obj.iDataColumn ]; 
                                        if ( sReturn == 'A' ) { 
                                          sReturn = '<b>A</b>'; 
                                        } 
                                        return sReturn; 
                                      } """).cmd 
  }
  
  private val columns = List(
                     aoCol(Some(sTitle("Rendering Engine")),None,None),
                     aoCol(Some(sTitle("Browser")),None,None),
                     aoCol(Some(sTitle("Platform(s)")),None,None),
                     aoCol(Some(sTitle("Engine Version")),Some(sClass("center")),None),
                     aoCol(Some(sTitle("CSS Grade")),Some(sClass("center")),Some(fnRender(highlightA) ) )
                    )

  private def rengineData = {
    val ccList:List[REngine]  = REngine.getAllList()
    ccList.map(c => aaDT(List(c.engine.is,c.browser.is,c.platform.is,c.version.is,c.grade.is)))
  }
                    
//  private val aoColumns = {
//    JsRaw(""" 
//         [
//            { "sTitle": "Engine" },
//            { "sTitle": "Browser" },
//            { "sTitle": "Platform" },
//            { "sTitle": "Version", "sClass": "center" },
//            { "sTitle": "Grade", "sClass": "center",
//                "fnRender": function(obj) {
//                    var sReturn = obj.aData[ obj.iDataColumn ];
//                    if ( sReturn == "A" ) {
//                        sReturn = "<b>A</b>";
//                    }
//                    return sReturn;
//                }
//            }
//        ]        
//    """).toJsCmd         
//  }
 
                  
  
}