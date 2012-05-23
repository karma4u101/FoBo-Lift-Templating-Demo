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

import code.model._

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
    FoBo.InitParam.ToolKit=FoBo.DataTables190
    FoBo.InitParam.ToolKit=FoBo.Knockout200
    FoBo.init()  

    // where to search snippet
    LiftRules.addToPackages("code")

    /*un-comment and switch to db of your liking */
    MySchemaHelper.initSquerylRecordWithInMemoryDB
    //MySchemaHelper.initSquerylRecordWithMySqlDB
    //MySchemaHelper.initSquerylRecordWithPostgresDB

    Props.mode match {
      case Props.RunModes.Development => {
        logger.info("RunMode is DEVELOPMENT")
        /*OBS! do no use this in a production env*/
        if (Props.getBool("db.schemify", false)) {
          MySchemaHelper.dropAndCreateSchema
        }
        // pass paths that start with 'console' to be processed by the H2Console servlet
        if (MySchemaHelper.isUsingH2Driver) {
          /* make db console browser-accessible in dev mode at /console 
           * see http://www.h2database.com/html/tutorial.html#tutorial_starting_h2_console 
           * Embedded Mode JDBC URL: jdbc:h2:mem:test User Name:test Password:test */
          logger.info("Set up H2 db console at /console ")
          LiftRules.liftRequest.append({
            case r if (r.path.partPath match { case "console" :: _ => true case _ => false }) => false
          })
        }
      }
      case Props.RunModes.Production => {
        logger.info("RunMode is PRODUCTION")
        if (Props.getBool("db.schemify", false)) {
          logger.warn("DB.SCHEMIFY is TRUE in production.props, db data will be reset on restart of app")
          MySchemaHelper.dropAndCreateSchema
        }else{
            logger.info("db.shemify is disabled in production.props")
        }        
      }
      case _                         => logger.info("RunMode is TEST, PILOT or STAGING")
    }    
    
    // Build SiteMap
    val entries = List(
      Menu.i("Home") / "index",
      
//      how to to make this work without # converted to %23 the api call below is working 
//      Menu.i("Home-Top") / "#spyhome",
//      Menu.i("About") / "#spyabout",

      
      Menu(Loc("Foundation", Link(List("foundation"), true, "/foundation/index"),
        "Foundation")),
      Menu(Loc("Bootstrap", Link(List("bootstrap"), true, "/bootstrap/index"),
        "Bootstrap")),
      Menu(Loc("JQuery-mobile", Link(List("jquery-mobile"), true, "/jquery-mobile/1.0.1/demos/index"),
        "JQuery-mobile")),
      Menu(Loc("JQuery-mobile-1.1.0", Link(List("jquery-mobile-1.1.0"), true, "/jquery-mobile/1.1.0/demos/index"),
        "JQuery-mobile-v1.1.0")),        
      Menu(Loc("DataTables", Link(List("datatables"), true, "/datatables/1.9.0/index"),
        "DataTables")),  
      Menu(Loc("FoBoAPI", Link(List("foboapi"), true, "/foboapi/#net.liftmodules.FoBo.package"),
        "FoBoAPI")),
      //FoBo will generate a nav dropdown from this    
      Menu.i("gendemo.dropdown1.text") / "#" >> LocGroup("frontNav") >> PlaceHolder submenus (
         Menu.i("gendemo.page1a.text") / "page1a" ,  
         Menu.i("gendemo.page1b.text") / "page1b" ,
         Menu.i("gendemo.page1c.text") / "page1c")        
    )   
      
    LiftRules.uriNotFound.prepend(NamedPF("404handler"){
      case (req,failure) => 
        NotFoundAsTemplate(ParsePath(List("404"),"html",false,false))
    })

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap(SiteMap(entries: _*))

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

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

