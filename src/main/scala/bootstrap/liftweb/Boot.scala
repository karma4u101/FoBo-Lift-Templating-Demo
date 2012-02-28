package bootstrap.liftweb

import _root_.net.liftweb._
import http.ResourceServer._
import actor._
import util._
import Helpers._
import common._
import http._
import sitemap._
import Loc._
import java.util.Locale
import java.sql.DriverManager
import _root_.net.liftweb.util.{ Props }
import _root_.net.liftweb.http.provider.HTTPRequest
import _root_.net.liftweb.http.auth.{ HttpBasicAuthentication, AuthRole, userRoles }
import net.liftmodules.FoBo

object localeOverride extends SessionVar[Box[Locale]](Empty)

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot extends Loggable {
  def boot {

   //If using defaults FoBo init params can be omitted
    FoBo.InitParam.JQuery=FoBo.JQuery171  
    FoBo.InitParam.ToolKit=FoBo.FoBo020
    FoBo.InitParam.ToolKit=FoBo.PrettifyJun2011
    FoBo.InitParam.ToolKit=FoBo.JQueryMobile101
    FoBo.init()  

    // where to search snippet
    LiftRules.addToPackages("code")
    
    // Build SiteMap
    val entries = List(
      Menu.i("Home") / "index",
      Menu(Loc("Foundation", Link(List("foundation"), true, "/foundation/index"),
        "Foundation")),
      Menu(Loc("Bootstrap", Link(List("bootstrap"), true, "/bootstrap/index"),
        "Bootstrap")),
      Menu(Loc("JQuery-mobile", Link(List("jquery-mobile"), true, "/jquery-mobile/1.0.1/demos/index"),
        "JQuery-mobile")),
      Menu(Loc("DataTables", Link(List("datatables"), true, "/datatables/1.9.0/index"),
        "DataTables")),  
      Menu(Loc("FoBoAPI", Link(List("foboapi"), true, "/foboapi/index"),
        "FoBoAPI"))        
    )   
      
    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap(SiteMap(entries: _*))

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Use jQuery 1.4
    LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    //notice fade out (start after x, fade out duration y)
    LiftRules.noticesAutoFadeOut.default.set((notices: NoticeType.Value) => {
      notices match {
        case NoticeType.Notice => Full((8 seconds, 4 seconds))
        case _                 => Empty
      }
    })

  }

}

