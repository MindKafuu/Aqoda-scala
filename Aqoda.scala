import Aqoda.RoomNo

object Aqoda {
  type RoomNo = String
}
case class Hotel(numberOfRoomsPerFloor: Int, numberOfFloors: Int)
case class Guest(name: String, age: Int)
case class Keycard()
case class BookingRecord(hotel: Hotel, guest: Guest, roomNo: RoomNo, keycard: Option[Keycard])

abstract class Aqoda {
  def book(hotel: Hotel, guest: Guest, roomNo: RoomNo): BookingRecord

  def checkin(hotel: Hotel, bookingRecord: BookingRecord): Keycard

  def availableRooms(hotel: Hotel, bookingRecord: BookingRecord): List[RoomNo]

  def checkout(hotel: Hotel, bookingRecord: BookingRecord): RoomNo

  def listGuests(hotel: Hotel, bookingRecord: BookingRecord, f: BookingRecord => Boolean): List[Guest]

  def getGuestInRoom(hotel: Hotel, bookingRecord: BookingRecord): Guest

  def checkoutByFloor(hotel: Hotel, keycard: Keycard, bookingRecord: BookingRecord): List[RoomNo]

  def bookByFloor(hotel: Hotel, guest: Guest, floor: Int): List[BookingRecord]
}

class HotelManager(hotel: Hotel) {
  var bookingRecords: List[BookingRecord] = List()

  def isBooked(roomNo: RoomNo): Boolean = ???

  def book(guest: Guest, roomNo: RoomNo): BookingRecord = ???

  def checkin(guest: Guest, roomNo: RoomNo): Keycard = ???

  def availableRooms(): List[RoomNo] = ???

  def checkout(guest: Guest, keycard: Keycard): RoomNo = ???

  def listGuests(f: BookingRecord => Boolean): List[Guest] = ???

  def getGuestInRoom(roomNo: RoomNo): Guest = ???

  def checkoutByFloor(floor: Int): List[RoomNo] = ???

  def bookByFloor(guest: Guest, floor: Int): List[BookingRecord] = ???
}

class Application {
  var manager: HotelManager

  def createHotel(numberOfRoomsPerFloor: Int, numberOfFloors: Int): Unit = {
    val hotel = Hotel(numberOfRoomsPerFloor, numberOfFloors)
    manager = new HotelManager(hotel)
  }

  def book(name: String, age: Int, roomNo: RoomNo): Unit = {
    val guest = Guest(name, age)
    if (manager.isBooked(roomNo)) {
      val bookingRecord = manager.book(guest, roomNo)
      println("shenme shenme")
    }
    else println("shenme shenme")
  }

  def checkin(name: String, age: Int, roomNo: RoomNo): Unit = {
    val guest = Guest(name, age)
    if (manager.isCheckedin())
    val keycard = manager.checkin(guest, roomNo)
  }

  def availableRooms(): Unit = {
    val rooms = manager.availableRooms()
  }

  def checkout(name: String, age: Int, keycard: Keycard): Unit = {

  }
}
