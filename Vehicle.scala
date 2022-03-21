import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Vehicle (vehicleNo:String, platform:ParkingLot){
  val entryTime: LocalDateTime = LocalDateTime.now.minusHours(3)
  platform.carDB(vehicleNo)=entryTime
}

class TwoWheeler(val vehicleNo:String, val platform:ParkingLot) extends Vehicle(vehicleNo,platform){
  platform.slotsTwoWheeler=platform.slotsTwoWheeler+1
  platform.approveParking()
  platform.slotDB(vehicleNo)=platform.slotsTwoWheeler
  def exit():Unit ={
    val exitTime: LocalDateTime = LocalDateTime.now
    platform.slotsTwoWheeler=platform.slotsTwoWheeler-1
    val hours = ChronoUnit.HOURS.between(entryTime, exitTime)
    if(hours<=2){
      println(s"Duration - $hours hours, Pay - Rs 20")
    }
    else if (hours>2 && hours<=4){
      println(s"Duration - $hours hours, Pay - Rs 50")
    }
    else{
      println(s"Duration - $hours hours, Pay - Rs 100")
    }
  }
}

class Hatchback(val vehicleNo:String, val platform:ParkingLot) extends Vehicle(vehicleNo,platform){
  platform.slotsHatchback=platform.slotsHatchback+1
  platform.approveParking()
  platform.slotDB(vehicleNo)=platform.slotsHatchback
  def exit():Unit ={
    val exitTime: LocalDateTime = LocalDateTime.now
    platform.slotsHatchback=platform.slotsHatchback-1
    val hours = ChronoUnit.HOURS.between(entryTime, exitTime)
    if(hours<=2){
      println(s"Duration - $hours hours, Pay - Rs 40")
    }
    else if (hours>2 && hours<=4){
      println(s"Duration - $hours hours, Pay - Rs 100")
    }
    else{
      println(s"Duration - $hours hours, Pay - Rs 200")
    }
  }
}

class Suv(val vehicleNo:String, val platform:ParkingLot) extends Vehicle(vehicleNo,platform){
  platform.slotsSuv=platform.slotsSuv+1
  platform.approveParking()
  platform.slotDB(vehicleNo)=platform.slotsHatchback
  def exit():Unit ={
    val exitTime: LocalDateTime = LocalDateTime.now
    platform.slotsSuv=platform.slotsSuv-1
    val hours = ChronoUnit.HOURS.between(entryTime, exitTime)
    if(hours<=2){
      println(s"Duration - $hours hours, Pay - Rs 60")
    }
    else if (hours>2 && hours<=4){
      println(s"Duration - $hours hours, Pay - Rs 150")
    }
    else{
      println(s"Duration - $hours hours, Pay - Rs 300")
    }
  }
}
