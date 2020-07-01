import java.io.File
import Aqoda.RoomNo
import scala.io.Source
import scala.collection.mutable.ListBuffer

object Aqoda {
  type RoomNo = String
}
case class Command(command: String, args: Array[String])
case class Hotel(numberOfRoomsPerFloor: Int, numberOfFloors: Int) {
  val roomsNo = List[]
}
case class Guest(name: String, age: Int)
case class Keycard()
case class BookingRecord(hotel: Hotel, guest: Guest, roomNo: RoomNo, var keycard: Option[Keycard])

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
  var bookingRecords: ListBuffer[BookingRecord] = ListBuffer.empty

  def isBooked(roomNo: RoomNo): Boolean =
    bookingRecords.exists(_.roomNo == roomNo)

  def book(guest: Guest, roomNo: RoomNo): BookingRecord = {
    val bookingRecord = BookingRecord(hotel, guest, roomNo, None)
    bookingRecords += bookingRecord
    bookingRecord
  }

  def isCheckedin(guest: Guest, roomNo: RoomNo): Boolean =
    bookingRecords.exists(bookingRecord => bookingRecord.guest == guest && bookingRecord.roomNo == roomNo)

//  def checkin(guest: Guest, roomNo: RoomNo): Keycard = {
//    val keycard = getKeycard()
//    val bookingRecord = bookingRecords.find(bookingRecord => bookingRecord.guest == guest && bookingRecord.roomNo == roomNo).get
//    bookingRecord.keycard = Some(keycard)
//    keycard
//  }

  def availableRooms(): List[RoomNo] = {
    List.empty
  }

  def checkout(guest: Guest, keycard: Keycard): RoomNo = ???

  private def listGuests(f: BookingRecord => Boolean): List[Guest] = ???

  def listGuestsByAge(age: Int): List[Guest] = {
    listGuests(_.guest.age > age)
  }

  def listGuestsByFloor(floor: String): List[Guest] = {
    listGuests(_.roomNo(0).toString == floor)
  }

  def getGuestInRoom(roomNo: RoomNo): Guest = ???

  def checkoutByFloor(floor: String): List[RoomNo] = ???

  def bookByFloor(guest: Guest, floor: String): List[BookingRecord] = ???
}

object Application {
//  var manager: HotelManager

  def createHotel(numberOfRoomsPerFloor: Int, numberOfFloors: Int): Hotel = {
    Hotel(numberOfRoomsPerFloor, numberOfFloors)

  }
//
//  def book(name: String, age: Int, roomNo: RoomNo): Unit = {
//    val guest = Guest(name, age)
//    if (manager.isBooked(roomNo)) {
//      val bookingRecord = manager.book(guest, roomNo)
//      println("")
//    }
//    else println("Cannot book room 203 for TonyStark, The room is currently booked by Thor.")
//  }
//
//  def checkin(name: String, age: Int, roomNo: RoomNo): Unit = {
//    val guest = Guest(name, age)
//    if (manager.isCheckedin(guest, roomNo)) {
//      val keycard = manager.checkin(guest, roomNo)
//      println("Room 202 is booked by TonyStark with keycard number 5.")
//    }
//    else println("")
//  }
//
//  def availableRooms(): Unit = {
//    val rooms = manager.availableRooms()
//  }
//
//  def checkout(name: String, age: Int, keycard: Keycard): Unit = {
//    val guest = Guest(name, age)
//    val room = manager.checkout(guest, keycard)
//  }
//
//  def listGuestsByAge(age: Int): Unit = {
//    val guests = manager.listGuestsByAge(age)
//  }
//
//  def listGuestsByFloor(floor: String): Unit = {
//    val guests = manager.listGuestsByFloor(floor)
//  }
//
//  def getGuestInRoom(roomNo: RoomNo): Unit = {
//    val guest = manager.getGuestInRoom(roomNo)
//  }
//
//  def checkoutByFloor(floor: String): Unit = {
//    val rooms = manager.checkoutByFloor(floor)
//  }
//
//  def bookByFloor(name: String, age: Int, floor: String): Unit = {
//    val guest = Guest(name, age)
//    val bookingRecords = manager.bookByFloor(guest, floor)
//  }

  def main(args: Array[String]): Unit = {
    val filename =  new File(getClass.getClassLoader.getResource("input.txt").getPath)
    val lines = Source.fromFile(filename).getLines.toList
    val commands = lines.map(line => {
      val cmd = line.split(' ')
      Command(cmd.head, cmd.tail)
    })
  }
}
