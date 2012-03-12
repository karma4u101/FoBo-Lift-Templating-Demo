package code
package model

//import lib.util._

object DemoData {

  def createDemoData {
    cityList().foreach(MySchema.city.insert(_))
  }

  private def cityList():List[City] = List(
    City.createRecord.idField(0).country("A").region("ra0").cityName("cn0").population(1),
    City.createRecord.idField(1).country("A").region("ra1").cityName("cn1").population(2),   
    City.createRecord.idField(2).country("A").region("ra2").cityName("cn2").population(3),    
    City.createRecord.idField(3).country("A").region("ra3").cityName("cn3").population(1),
    City.createRecord.idField(4).country("A").region("ra4").cityName("cn4").population(2),
    City.createRecord.idField(5).country("A").region("ra5").cityName("cn5").population(3),
    City.createRecord.idField(6).country("A").region("ra6").cityName("cn6").population(1),
    City.createRecord.idField(7).country("A").region("ra7").cityName("cn7").population(2),
    City.createRecord.idField(8).country("A").region("ra8").cityName("cn8").population(3),
    City.createRecord.idField(9).country("A").region("ra9").cityName("cn9").population(1),
    
    City.createRecord.idField(10).country("B").region("rb0").cityName("cn10").population(1),
    City.createRecord.idField(11).country("B").region("rb1").cityName("cn11").population(2),
    City.createRecord.idField(12).country("B").region("rb2").cityName("cn12").population(3),
    City.createRecord.idField(13).country("B").region("rb3").cityName("cn13").population(1),
    City.createRecord.idField(14).country("B").region("rb4").cityName("cn14").population(2),
    City.createRecord.idField(15).country("B").region("rb5").cityName("cn15").population(3),
    City.createRecord.idField(16).country("B").region("rb6").cityName("cn16").population(1),
    City.createRecord.idField(17).country("B").region("rb7").cityName("cn17").population(2),
    City.createRecord.idField(18).country("B").region("rb8").cityName("cn18").population(3),
    City.createRecord.idField(19).country("B").region("rb9").cityName("cn19").population(1),

    City.createRecord.idField(10).country("C").region("rc0").cityName("cn20").population(1),
    City.createRecord.idField(11).country("C").region("rc1").cityName("cn21").population(2),
    City.createRecord.idField(12).country("C").region("rc2").cityName("cn22").population(3),
    City.createRecord.idField(13).country("C").region("rc3").cityName("cn23").population(1),
    City.createRecord.idField(14).country("C").region("rc4").cityName("cn24").population(2),
    City.createRecord.idField(15).country("C").region("rc5").cityName("cn25").population(3),
    City.createRecord.idField(16).country("C").region("rc6").cityName("cn26").population(1),
    City.createRecord.idField(17).country("C").region("rc7").cityName("cn27").population(2),
    City.createRecord.idField(18).country("C").region("rc8").cityName("cn28").population(3),
    City.createRecord.idField(19).country("C").region("rc9").cityName("cn29").population(1),
    
    City.createRecord.idField(20).country("D").region("rd0").cityName("cn30").population(1),
    City.createRecord.idField(21).country("D").region("rd1").cityName("cn31").population(2),
    City.createRecord.idField(22).country("D").region("rd2").cityName("cn32").population(3),
    City.createRecord.idField(23).country("D").region("rd3").cityName("cn33").population(1),
    City.createRecord.idField(24).country("D").region("rd4").cityName("cn34").population(2),
    City.createRecord.idField(25).country("D").region("rd5").cityName("cn35").population(3),
    City.createRecord.idField(26).country("D").region("rd6").cityName("cn36").population(1),
    City.createRecord.idField(27).country("D").region("rd7").cityName("cn37").population(2),
    City.createRecord.idField(28).country("D").region("rd8").cityName("cn38").population(3),
    City.createRecord.idField(29).country("D").region("rd9").cityName("cn39").population(1),
    
    City.createRecord.idField(30).country("E").region("re0").cityName("cn40").population(1),
    City.createRecord.idField(31).country("E").region("re1").cityName("cn41").population(2),
    City.createRecord.idField(32).country("E").region("re2").cityName("cn42").population(3),
    City.createRecord.idField(33).country("E").region("re3").cityName("cn43").population(1),
    City.createRecord.idField(34).country("E").region("re4").cityName("cn44").population(2),
    City.createRecord.idField(35).country("E").region("re5").cityName("cn45").population(3),
    City.createRecord.idField(36).country("E").region("re6").cityName("cn46").population(1),
    City.createRecord.idField(37).country("E").region("re7").cityName("cn47").population(2),
    City.createRecord.idField(38).country("E").region("re8").cityName("cn48").population(3),
    City.createRecord.idField(39).country("E").region("re9").cityName("cn49").population(1)     
  )

}