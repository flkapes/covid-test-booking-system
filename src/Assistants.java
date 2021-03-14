public class Assistants { // University Volunteers' information that perform COVID tests
  private String name; // Name of the Assistant
  private String email; // Email of the Assistant

  /** @return Returns the name of the Assistant as a String */
  public String getName() {
    return name;
  }

  /** @return Returns the email of the Assistant as a String */
  public String getEmail() {
    return email;
  }

  /**
   * @param name The name of the Assistant
   * @param email The email of the assistant
   */
  public Assistants(String name, String email) {
    String sub_email = "uok.ac.uk";
    String[] result = email.split("@");
    if (!(name.isEmpty()) && result[1].equals(sub_email)) {
      this.name = name;
      this.email = email;
    }
  }

  /**
   * @return Returns a String that contains an assistant according to the format supplied in the
   *     specification
   */
  public String printAssistants() {
    String dummyVar = "| " + name + " | " + email + " |";
    return dummyVar;
  }
}
