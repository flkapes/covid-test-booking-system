import java.util.ArrayList;
import java.util.List;

public class UniversityResources { // Inventory of Available Resources (Assistants and Rooms)
  private final List<Room> rooms; // A list of Rooms that the University can use for COVID testing
  private final List<Assistants>
      assistants; // A list of Assistants that the University will allocate for COVID tests

  public UniversityResources() {
    List<Assistants> assistants = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    this.assistants = assistants;
    this.rooms = rooms;
  }

  /** @param assistant Adds the assistant to the Assistants ArrayList */
  public void addAssistant(Assistants assistant) {
    assistants.add(assistant);
  }

  /** @param room2 Adds the Room to the Rooms ArrayList */
  public void addRoom(Room room2) {
    rooms.add(room2);
  }

  /**
   * @param index The position of the Room in the Rooms ArrayList
   * @return Returns the Room Object in the Rooms ArrayList that was being searched for
   */
  // Gets the room with position: index from the Rooms ArrayList
  public Room getRoom(int index) {
    return rooms.get(index);
  }

  /**
   * @param index The position of the Assistant in the Assistants ArrayList
   * @return Returns the Assistants Object in the Assistants ArrayList that was being searched for
   */
  // Gets the Assistant with position: index from the Assistants ArrayList
  public Assistants getAssistant(int index) {
    return assistants.get(index);
  }

  /**
   * Uses a for loop to iterate through the Assistants List and adds them to a String for printing
   * later on.
   *
   * @return String of multiple Assistants
   */
  public String printAssistants1() {
    String temp = "";
    int z = 11;
    for (Assistants assistant : assistants) {
      temp += z + ". | " + assistant.getName() + " | " + assistant.getEmail() + " |\n";
      z++;
    }
    return temp;
  }

  /**
   * Uses a for loop to iterate through the Rooms List and adds them to a String for printing later
   * on
   *
   * @return String of multiple Rooms
   */
  public String printRooms() {
    String temp = "";
    int z = 11;
    for (Room room : rooms) {
      temp += z + ". | " + room.getRoomCode() + " | " + room.getRoomCapacity() + " |\n";
      z++;
    }
    return temp;
  }
}
