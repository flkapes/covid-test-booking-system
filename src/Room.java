public class Room { // Rooms that COVID tests are conducted in
  private String roomCode; // The Room code
  private int roomCapacity; // The capacity of the Room

  /** @return Returns the Room code as a String */
  public String getRoomCode() {
    return roomCode;
  }

  /** @return Returns the Room capacity as an integer */
  public int getRoomCapacity() {
    return roomCapacity;
  }

  /**
   * @param roomCode The room code
   * @param roomCapacity The capacity of the room
   */
  public Room(String roomCode, int roomCapacity) {
    if (roomCapacity > 0) {
      this.roomCode = roomCode;
      this.roomCapacity = roomCapacity;
    }
  }

  /**
   * @return Returns a String containing the Room code and Room capacity formatted according to the
   *     specification
   */
  public String printRoom() {
    String dummyVar = "| " + getRoomCode() + " | " + getRoomCapacity() + " |";
    return dummyVar;
  }
}
