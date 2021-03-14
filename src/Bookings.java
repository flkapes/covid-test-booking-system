public
class Bookings { // The union of a free assistant on shift and an available or empty bookable room
  // at a specific timeslot
  private AssistantOnShift
      assistantOnShift; // The Assistant on Shift that will be assigned to the Booking
  private BookableRoom bookableRoom; // The Bookable Room that will be used for the Booking
  private String status; // The Status of the Booking
  private String studentEmail; // The Email of the Student that will be taking the test
  private String date; // The date of the Booking
  private String time; // The time of the Booking

  /** @return Returns the AssistantOnShift */
  public AssistantOnShift getAssistant() {
    return assistantOnShift;
  }

  /** @return Returns the BookableRoom */
  public BookableRoom getRoom() {
    return bookableRoom;
  }

  /** @return Returns the Date */
  public String getDate() {
    return date;
  }

  /** @return Returns the Time */
  public String getTime() {
    return time;
  }

  /** @return Returns the Booking Status */
  public String getStatus() {
    return status;
  }

  /** @return Returns the Student Email */
  public String getStudentEmail() {
    return studentEmail;
  }

  /**
   * @param room BookableRoom that will be used to create the Booking
   * @param assistant AssistantOnShift that will be used to create the booking
   * @param status Status of the Booking
   * @param studentEmail Email of the student
   */
  public Bookings(
      BookableRoom room, AssistantOnShift assistant, String status, String studentEmail) {
    if (status.equals("COMPLETED") || !(room.getStatus().equals("FULL"))) {
      this.assistantOnShift = assistant;
      this.bookableRoom = room;
      this.status = status;
      this.date = bookableRoom.getDate();
      this.time = bookableRoom.getTime();
      if (studentEmail.split("@")[1].equals("uok.ac.uk")) {
        this.studentEmail = studentEmail;
      }
    }
  }

  /**
   * @return Returns a String with the Booking Info following the format given in the specification
   */
  public String printTemplate() {
    return "| "
        + date
        + " "
        + time
        + " | "
        + status
        + " | "
        + assistantOnShift.getAssistantss().getEmail()
        + " | "
        + bookableRoom.getRoom().getRoomCode()
        + " | "
        + studentEmail
        + " |";
  }
}
