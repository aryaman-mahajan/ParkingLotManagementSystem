import org.scalatest.funsuite.AnyFunSuite

class ParkingLotSuite extends org.scalatest.funsuite.AnyFunSuite{
  val platform1 = ParkingLot(1,3,2)
  val bike1= new TwoWheeler("Bike1",platform1)
  test("Parking Lot is full for Bikes"){
    assertThrows[Exception]{val bike2= new TwoWheeler("Bike2",platform1)}
  }
  test("Allows entry of Bike on exit of 1"){
    assertCompiles{
      """bike1.exit()
        |val bike2= new TwoWheeler("Bike2",platform1)""".stripMargin}
  }
  val car1= new Hatchback("Car1",platform1)
  val car2= new Hatchback("Car2",platform1)
  val car3= new Hatchback("Car3",platform1)
  test("Parking Lot is full for Hatchbacks"){
    assertThrows[Exception]{val car4= new Hatchback("Car4",platform1)}
  }
  test("Allows entry of Car on exit of 1"){
    assertCompiles{
      """car3.exit()
        |val car4= new Hatchback("Car4",platform1)""".stripMargin}
  }
  val suv1= new Suv("Suv1",platform1)
  val suv2= new Suv("Suv2",platform1)
  test("Parking Lot is full for Suv"){
    assertThrows[Exception]{val suv3= new Suv("Suv3",platform1)}
  }
  test("Allows entry of Suv on exit of 1"){
    assertCompiles{
      """suv2.exit()
        |val suv3= new Suv("Suv3",platform1)""".stripMargin}
  }
  test("Vehicle Not in Parking Lot"){
    assertResult(println("Vehicle not in Parking Lot")){platform1.getDetails("Car7")}
  }
}
