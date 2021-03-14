import java.util.*;

public
class BookingSystem { // Responsible for the bulk of the functionality of the COVID Testing System
  public List<BookableRoom> bookableRooms; // List of Bookable Rooms is named rooms previously
  public List<AssistantOnShift> assistantOnShift; // List of Assistants on Shift
  public List<Bookings> bookings; // List of Bookings
  public List<Room> rooms; // List of Rooms
  public List<BookableRoom> emptyBRooms; // List of empty BookableRooms
  public List<AssistantOnShift> emptyAssistantsOnShift; // List of Free AssistantsOnShift
  public List<BookableRoom> availableBookableRooms; // List of available BookableRooms
  public List<AssistantOnShift> availableAssistantsOnShift; // List of available AssistantsOnShift
  public Map<BookableRoom, AssistantOnShift>
      zipped; // LinkedHashMap of available BookableRooms and AssistantsOnShift

  public List<AssistantOnShift> getAssistantsOnShift() {
    return assistantOnShift;
  }

  /**
   * bookableRooms is an ArrayList of the bookable rooms that are created by the user with the
   * interface, it contains:
   *
   * <p>
   *
   * <ul>
   *   <li>Date and Time Slot of Availability
   *   <li>Status of the Room
   *   <li>Room code
   *   <li>Occupancy of the room
   * </ul>
   *
   * assistantOnShift is an ArrayList of Assistants that are currently on Shift, it contains:
   *
   * <ul>
   *   <li>Date and Time Slot of Availability
   *   <li>Status of the Assistant
   *   <li>Assistants Email Address
   * </ul>
   *
   * bookings is an ArrayList of Bookings, it contains:
   *
   * <ul>
   *   <li>A Bookable Room
   *   <li>An Assistant on Shift
   *   <li>Status of the Booking
   *   <li>Student Email
   * </ul>
   *
   * zipped is a LinkedHashMap that contains pairs of bookable rooms below full occupancy and
   * assistants on shift that are free
   */
  public BookingSystem() {
    List<BookableRoom> availableBookableRooms = new ArrayList<>();
    List<BookableRoom> bookableRooms = new ArrayList<>();
    List<AssistantOnShift> assistantOnShift = new ArrayList<>();
    List<Bookings> bookings = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    List<AssistantOnShift> emptyAssistantsOnShift = new ArrayList<>();
    List<BookableRoom> emptyBRooms = new ArrayList<>();
    List<AssistantOnShift> availableAssistantsOnShift = new ArrayList<>();
    Map<BookableRoom, AssistantOnShift> zipped = new LinkedHashMap<>();
    this.assistantOnShift = assistantOnShift;
    this.emptyBRooms = emptyBRooms;
    this.bookableRooms = bookableRooms;
    this.bookings = bookings;
    this.rooms = rooms;
    this.zipped = zipped;
    this.availableAssistantsOnShift = availableAssistantsOnShift;
    this.availableBookableRooms = availableBookableRooms;
    this.emptyAssistantsOnShift = emptyAssistantsOnShift;
  }

  // The following section will be dedicated to the addition, update, removal, and listing of
  // Bookable Rooms

  /**
   * @param room Room that will be used to create a new BookableRoom
   * @param date Date that the new BookableRoom will be available for booking on
   * @param time Time that the new BookableRoom will be available for booking at
   * @param occupancy Occupancy of the new bookable room
   */
  public void addBookableRoom(Room room, String date, String time, int occupancy) {
    if (time.equals("7:00") || time.equals("8:00") || time.equals("9:00")) {
      bookableRooms.add(
          new BookableRoom(
              room, date, time, occupancy)); // Adds the instance of bookable room to the list
    } else {
      System.exit(0);
    }
  }

  /**
   * @param index Uses the index provided as an argument to remove the bookable room at that
   *     position
   */
  public void removeBookableRoom(int index) {
    bookableRooms.remove(index); // Removes the bookable room from the list
  }

  /**
   * @return Returns a string of BookableRooms following the template provided in the specification
   */
  public String showBookableRooms() {
    String dummyVariable = "\nBookable Rooms: \n";
    int z = 11;
    for (BookableRoom bookableRoom : bookableRooms) {
      dummyVariable = dummyVariable + z + ". " + bookableRoom.printBookableRoom() + "\n";
      z++;
    }
    return dummyVariable;
  }

  /**
   * @return Returns a String of empty BookableRooms following the template provided in the
   *     specification
   */
  public String showEmptyBookableRooms() {
    String dummyVariable = "\nRemovable Bookable Rooms: \n";
    int z = 11;
    for (BookableRoom bookableRoom : bookableRooms) {
      if (bookableRoom.getStatus().equals("EMPTY")) {
        dummyVariable = dummyVariable + z + ". " + bookableRoom.printBookableRoom() + "\n";
        z++;
      }
    }
    return dummyVariable;
  }

  /** @return Returns a list of empty BookableRooms */
  public List showEmptyBookableRoomsList() {
    for (BookableRoom bookableRoom : bookableRooms) {
      if (bookableRoom.getStatus().equals("EMPTY")) {
        emptyBRooms.add(bookableRoom);
      }
    }
    return emptyBRooms;
  }

  /**
   * @param index The position of the BookableRoom object in the BookableRooms ArrayList
   * @return Returns the BookableRoom object that was being searched for
   */
  public BookableRoom getBookableRoom(int index) {
    int i = 0;
    for (Map.Entry<BookableRoom, AssistantOnShift> entry : zipped.entrySet()) {
      if (i == 0) {
        availableBookableRooms.add(entry.getKey());
      }
    }
    return availableBookableRooms.get(index);
  }

  /**
   * @param room The BookableRoom that has just been booked The BookableRoom's info is used to
   *     create a new Bookable Room but with the occupancy increased by 1
   */
  public void updateBookableRoomOccupancy(BookableRoom room) {
    int updatedOccupancy = room.getOccupancy() + 1; // Gets the occupancy and increases it by one
    Room a = room.getRoom();
    addBookableRoom(
        a,
        room.getDate(),
        room.getTime(),
        updatedOccupancy); // Creates a new bookable room with updated occupancy
    bookableRooms.remove(room); // Removes the old bookable room
  }

  // This section is dedicated to the addition, removal, and listing of Assistants currently on
  // Shift

  /**
   * @param assistant The assistant that is going to be put on shift
   * @param date The date that the assistant will be put on shift
   * @param status The status of the Assistant on that Day
   */
  public void addAssistantShift(Assistants assistant, String date, String status) {
    String[] time = new String[] {"7:00", "8:00", "9:00"};
    for (int i = 0; i < 3; i++) {
      assistantOnShift.add(new AssistantOnShift(assistant, date, time[i], status));
    }
  }

  /**
   * @param assistants The assistant that will be added to the AssistantsOnShift list
   * @param date The date on which the Assistant will be working
   * @param time The time at which the Assistant on Shift will be added
   * @param status The status of the AssistantOnShift at that time
   */
  public void addAssistantOnShiftSpecial(
      Assistants assistants, String date, String time, String status) {
    assistantOnShift.add(new AssistantOnShift(assistants, date, time, status));
  }

  /**
   * @param assistant11 The assistant who's status will be changed
   * @param newStatus The updated status of the assistant
   */
  public void updateAssistantStatus(AssistantOnShift assistant11, String newStatus) {
    assistantOnShift.add(
        new AssistantOnShift(
            assistant11.getAssistantss(), assistant11.getDate(), assistant11.getTime(), newStatus));
    assistantOnShift.remove(assistant11); // Removes the old bookable room
  }

  /**
   * @return Returns a String of all the AssistantsOnShift using the format provided in the
   *     specification
   */
  public String showAssistantsOnShift() {
    String dummyVariable = "\nAssistants on shift: \n";
    int z = 11;
    for (int i = 0; i < assistantOnShift.size(); i++) {
      dummyVariable =
          dummyVariable
              + z
              + ". | "
              + getAssistantsOnShift().get(i).getDate()
              + " "
              + getAssistantsOnShift().get(i).getTime()
              + " | "
              + assistantOnShift.get(i).getStatus()
              + " | "
              + assistantOnShift.get(i).getAssistantss().getEmail()
              + " |\n";
      z++;
    }
    return dummyVariable;
  }

  /**
   * @return Returns a String of free AssistantsOnShift using the format provided in the
   *     specification
   */
  public String showFreeAssistantsOnShift() {
    String dummyVariable = "\nAssistants On Shift: \n";
    int z = 11;
    for (AssistantOnShift onShift : assistantOnShift) {
      if (onShift.getStatus().equals("FREE")) {
        dummyVariable = dummyVariable + z + ". " + onShift.printTemplate() + "\n ";
        z++;
      }
    }
    return dummyVariable;
  }

  /** @return Returns a List of free AssistantsOnShift */
  public List showFreeAssistantsOnShiftList() {
    for (int i = 0; i < assistantOnShift.size(); i++) {
      if (assistantOnShift.get(i).getStatus().equals("FREE")) {
        emptyAssistantsOnShift.add(assistantOnShift.get(i));
      }
    }
    return emptyAssistantsOnShift;
  }

  /**
   * @param index The position of the AssistantOnShift object in the AssistantsOnShift ArrayList
   * @return The AssistantOnShift object that was being searched for
   */
  public AssistantOnShift getAssistontOnShift(int index) {
    int i = 0;
    for (Map.Entry<BookableRoom, AssistantOnShift> entry : zipped.entrySet()) {
      if (i == 0) {
        availableAssistantsOnShift.add(entry.getValue());
      }
    }
    return availableAssistantsOnShift.get(index);
  }

  // The following section is for testing methods to update status and adjust as bookings are made

  /**
   * @param room The BookableRoom that will be used for the COVID test
   * @param assistant The AssistantOnShift that will perform the COVID test
   * @param status The status of the Booking
   * @param studentEmail The email of the Student taking the test
   */
  public void addBookingSpecial(
      BookableRoom room, AssistantOnShift assistant, String status, String studentEmail) {
    bookings.add(new Bookings(room, assistant, status, studentEmail));
  }

  /**
   * @param roomb The BookableRoom that will be used for the COVID test
   * @param assistantb The AssistantOnShift that will perform the COVID test
   * @param status The status of the Booking
   * @param studentEmail The email of the Student taking the test
   */
  public void addBooking(
      BookableRoom roomb, AssistantOnShift assistantb, String status, String studentEmail) {
    bookings.add(new Bookings(roomb, assistantb, status, studentEmail));
    updateBookableRoomOccupancy(
        roomb); // Updates the occupancy of the BookableRoom used for the Booking
    updateAssistantStatus(
        assistantb, "BUSY"); // Updates the status of the AssistantOnShift performing the test
  }

  /** @param booking The Booking that will be removed from the bookings ArrayList */
  public void removeBooking(Bookings booking) {
    bookings.remove(booking);
  }

  /**
   * @param index The position of the Booking in the Bookings ArrayList
   * @return the Booking object at the position: index in the Bookings Arraylist
   */
  public Bookings getBooking(int index) {
    return bookings.get(index);
  }

  /** @param booking The booking that will have its status changed to CONCLUDED */
  public void concludeBooking(Bookings booking) {
    bookings.add(
        new Bookings(
            booking.getRoom(), booking.getAssistant(), "COMPLETED", booking.getStudentEmail()));
    bookings.remove(booking);
  }

  /** @return Returns a String of available TimeSlots for booking */
  public String crossCheck() {
    String output = "";
    int i = 11;
    String temp = "";
    for (BookableRoom bookableRoom : bookableRooms) { // Loops through each and every BookableRoom
      for (AssistantOnShift assistantOnShift :
          assistantOnShift) { // Checks all AssistantsOnShift against every BookableRoom to find
        // timeSlots
        if (assistantOnShift.getStatus().equals("FREE")
            && !bookableRoom.getStatus().equals("FULL")
            && bookableRoom.getTime().equals(assistantOnShift.getTime())
            && bookableRoom.getDate().equals(assistantOnShift.getDate())) {
          if (!temp.contains(
              assistantOnShift
                  .printTemplate())) { // temp is a temporary String that gets the template of an
            // AssistantOnShift that has already been matched to a
            // BookableRoom and stores it to prevent duplicate timeSlots
            output +=
                i + ". | " + assistantOnShift.getDate() + " " + assistantOnShift.getTime() + " |\n";
            temp += assistantOnShift.printTemplate();
            i++;
          } else {
            continue;
          }
        }
      }
    }
    return output;
  }

  /** Places matching BookableRooms and Assistants in a LinkedHashMap */
  public void crossCheckList() {
    for (BookableRoom bookableRoom : bookableRooms) { // Loops through each and every BookableRoom
      for (AssistantOnShift assistantOnShift :
          assistantOnShift) { // Checks all AssistantsOnShift against every BookableRoom to find
        // matching pairs
        if (assistantOnShift.getStatus().equals("FREE")
            && !bookableRoom.getStatus().equals("FULL")
            && bookableRoom.getTime().equals(assistantOnShift.getTime())
            && bookableRoom.getDate().equals(assistantOnShift.getDate())) {
          if (!zipped.containsValue(assistantOnShift)) {
            zipped.put(bookableRoom, assistantOnShift);
          }
        }
      }
    }
  }

  /** @return Returns a String of All Bookings */
  public String printBookings() {
    String o = "";
    for (int i = 0; i < bookings.size(); i++) {
      o +=
          (i + 11)
              + ". | "
              + bookings.get(i).getDate()
              + " "
              + bookings.get(i).getTime()
              + " | "
              + bookings.get(i).getStatus()
              + " | "
              + bookings.get(i).getAssistant().getAssistantss().getEmail()
              + " | "
              + bookings.get(i).getRoom().getRoom().getRoomCode()
              + " | "
              + bookings.get(i).getStudentEmail()
              + " |\n";
    }
    return o;
  }

  /** @return Returns a String of all Scheduled Bookings */
  public String printScheduledBookings() {
    String o = "";
    int z = 11;
    for (int i = 0; i < bookings.size(); i++) {
      if (bookings.get(i).getStatus().equals("SCHEDULED")) {
        o +=
            (z)
                + ". | "
                + bookings.get(i).getDate()
                + " "
                + bookings.get(i).getTime()
                + " | "
                + bookings.get(i).getStatus()
                + " | "
                + assistantOnShift.get(i).getAssistantss().getEmail()
                + " | "
                + bookableRooms.get(i).getRoom().getRoomCode()
                + " | "
                + bookings.get(i).getStudentEmail()
                + " |\n";
        z++;
      }
    }
    return o;
  }

  /** @return Returns a String of all Completed Bookings */
  public String printCompletedBookings() {
    String o = "";
    int z = 11;
    for (int i = 0; i < bookings.size(); i++) {
      if (bookings.get(i).getStatus().equals("COMPLETED")) {
        o +=
            (z)
                + ". | "
                + bookings.get(i).getDate()
                + " "
                + bookings.get(i).getTime()
                + " | "
                + bookings.get(i).getStatus()
                + " | "
                + assistantOnShift.get(i).getAssistantss().getEmail()
                + " | "
                + bookableRooms.get(i).getRoom().getRoomCode()
                + " | "
                + bookings.get(i).getStudentEmail()
                + " |\n";
        z++;
      }
    }
    return o;
  }
}
