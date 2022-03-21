import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import scala.collection.mutable

case class ParkingLot(maxTwoWheeler:Int, maxHatchback:Int, maxSuv:Int){
  var slotsHatchback = 0
  var slotsSuv = 0
  var slotsTwoWheeler = 0
  val slotDB: mutable.Map[String, Int] = scala.collection.mutable.Map[String,Int]()
  val carDB: mutable.Map[String, LocalDateTime] = scala.collection.mutable.Map[String,LocalDateTime]()
  def approveParking(): Unit ={
    if(slotsTwoWheeler>maxTwoWheeler){
      slotsTwoWheeler=slotsTwoWheeler-1
      throw new Exception("Parking Lot is full for TwoWheeler")
    }
    if(slotsHatchback>maxHatchback){
      slotsHatchback=slotsHatchback-1
      throw new Exception("Parking Lot is full for Hatchback")
    }
    if(slotsSuv>maxSuv){
      slotsSuv=slotsSuv-1
      throw new Exception("Parking Lot is full for Suv")
    }
  }
  def getDetails (vehicleNoToFind:String):Unit = {
    try {
      val entryTime: LocalDateTime = carDB(vehicleNoToFind)
      val currentTime: LocalDateTime = LocalDateTime.now.minusHours(1)
      val duration = ChronoUnit.HOURS.between(entryTime, currentTime)
      print(s"Vehicle No - $vehicleNoToFind, LotNo - ${slotDB(vehicleNoToFind)}, Duration - $duration hours")
    } catch {
      case _: Throwable => println("Vehicle not in Parking Lot")
    }
  }
}