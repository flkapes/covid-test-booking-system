public class BookableRoom {
  private Room room; // Room object that will be recorded as Bookable
  private String status; // The status of the Room
  private int occupancy; // The Occupancy of the BookableRoom, set to 0 in BookingApp
  private String date; // The date at which the BookableRoom will be Available
  private String time; // The time at which the BookableRoom will be Available

  /** @return Returns the Room */
  public Room getRoom() {
    return this.room;
  }

  /** @return Returns the Occupancy */
  public int getOccupancy() {
    return occupancy;
  }

  /** @return Returns the Status of the Room */
  public String getStatus() {
    return status;
  }

  /** @return Returns the Date */
  public String getDate() {
    return date;
  }

  /** @return Returns the Time */
  public String getTime() {
    return time;
  }

  /** @return Returns the Capacity of the Room */
  public int getRCapacity() {
    return room.getRoomCapacity();
  }

  /**
   * @param room2 The room that will be made into a Bookable Room
   * @param date The date the new bookable room will be available for use on
   * @param time The time the room will be available for use at
   * @param occupancy The number of people in the room, should be 0 on creation for most rooms
   */
  public BookableRoom(Room room2, String date, String time, int occupancy) {
    this.occupancy = occupancy;
    this.time = time;
    this.room = room2;
    if (occupancy == 0) {
      this.status = "EMPTY";
    }
    if (occupancy < getRCapacity() && occupancy > 0) {
      this.status = "AVAILABLE";
    }
    if (occupancy == getRCapacity()) {
      this.status = "FULL";
    }
    this.date = date;
    this.room = room2;
  }

  /**
   * @return Returns a String of the BookableRoom information following the format provided in the
   *     specification
   */
  public String printBookableRoom() {
    return "| "
        + date
        + " "
        + time
        + " | "
        + status
        + " | "
        + room.getRoomCode()
        + " | occupancy: "
        + occupancy
        + " |";
  }
}
