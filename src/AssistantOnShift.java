public class AssistantOnShift { // Assistants that are assigned to dates and times for COVID testing
  // availability
  private Assistants assistants;
  private String time;
  private String date;
  private String status;

  /** @return Returns an Assistants object */
  public Assistants getAssistantss() {
    return assistants;
  }

  /** @return Returns the time as a String */
  public String getTime() {
    return this.time;
  }

  /** @return Returns the Status of the Assistant as a String */
  public String getStatus() {
    return this.status;
  }

  /** @return Returns the Date that the Assistant is On Shift as a String */
  public String getDate() {
    return this.date;
  }

  /**
   * @param assistant The Assistant object that is being put on shift
   * @param date The date that the Assistant will be working on
   * @param time The time that the Assistant will be working at
   * @param status The status of the Assistant at that specific date and time
   */
  public AssistantOnShift(Assistants assistant, String date, String time, String status) {
    this.assistants = assistant;
    this.date = date;
    this.time = time;
    this.status = status;
  }

  /** @return Returns an AssistantOnShift as a String formatted according to the specification */
  public String printTemplate() {
    return "| " + getDate() + " " + getTime() + " | " + getAssistantss().getEmail() + " |";
  }
}
