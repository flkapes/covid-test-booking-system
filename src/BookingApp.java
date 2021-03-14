import java.util.Scanner;

public class BookingApp { // COVID Test Booking CLI

  public static int display_menu() {
    System.out.println("University of Knowledge - COVID test \n");
    System.out.println("Manage Bookings \n");
    System.out.println("Please, enter the number to select your option: \n");
    System.out.println("To manage Bookable Rooms: ");
    System.out.println("\t1. List ");
    System.out.println("\t2. Add ");
    System.out.println("\t3. Remove ");
    System.out.println("To manage Assistants on Shift: ");
    System.out.println("\t4. List ");
    System.out.println("\t5. Add ");
    System.out.println("\t6. Remove ");
    System.out.println("To manage Bookings: ");
    System.out.println("\t7. List ");
    System.out.println("\t8. Add ");
    System.out.println("\t9. Remove");
    System.out.println("\t10. Conclude");
    System.out.println(
        "After selecting one the options above, you will be presented other screens.");
    System.out.println("If you press 0, you will be able to return to this main menu.");
    System.out.println("Press -1 (or ctrl+c) to quit this application. \n");
    return 1;
  }

  /**
   * Firstly, the main method loads the required Assistants, Rooms, Bookable Rooms, Assistants On
   * Shift, and Bookings
   *
   * <p>Second, the main method uses a switch statement to allow the user to navigate through the
   * menu
   */
  public static void main(String[] args) {
    BookingSystem bookingSystem = new BookingSystem();
    UniversityResources universityResources = new UniversityResources();

    universityResources.addAssistant(new Assistants("Jack Wheat", "jwheat@uok.ac.uk"));
    universityResources.addAssistant(new Assistants("Sammy Gilkinson", "sgilkinson@uok.ac.uk"));
    universityResources.addAssistant(new Assistants("Amy Santiago", "asantiago@uok.ac.uk"));

    universityResources.addRoom(new Room("IC2333", 23));
    universityResources.addRoom(new Room("IC2344", 28));
    universityResources.addRoom(new Room("IC2311", 18));

    bookingSystem.addBookableRoom(universityResources.getRoom(0), "14/03/2021", "7:00", 23);
    bookingSystem.addBookableRoom(universityResources.getRoom(0), "14/03/2021", "8:00", 0);
    bookingSystem.addBookableRoom(universityResources.getRoom(0), "14/03/2021", "9:00", 11);
    bookingSystem.addBookableRoom(universityResources.getRoom(1), "14/03/2021", "7:00", 28);
    bookingSystem.addBookableRoom(universityResources.getRoom(1), "14/03/2021", "8:00", 8);
    bookingSystem.addBookableRoom(universityResources.getRoom(1), "14/03/2021", "9:00", 1);
    bookingSystem.addBookableRoom(universityResources.getRoom(2), "14/03/2021", "7:00", 18);
    bookingSystem.addBookableRoom(universityResources.getRoom(2), "14/03/2021", "8:00", 15);
    bookingSystem.addBookableRoom(universityResources.getRoom(2), "14/03/2021", "9:00", 11);

    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(0), "14/03/2021", "7:00", "FREE");
    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(1), "14/03/2021", "8:00", "BUSY");
    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(2), "14/03/2021", "8:00", "BUSY");
    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(0), "14/03/2021", "9:00", "BUSY");
    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(1), "14/03/2021", "7:00", "FREE");
    bookingSystem.addAssistantOnShiftSpecial(
        universityResources.getAssistant(2), "14/03/2021", "9:00", "FREE");

    bookingSystem.addBookingSpecial(
        bookingSystem.bookableRooms.get(1),
        bookingSystem.assistantOnShift.get(1),
        "SCHEDULED",
        "gp325@uok.ac.uk");
    bookingSystem.addBookingSpecial(
        bookingSystem.bookableRooms.get(2),
        bookingSystem.assistantOnShift.get(3),
        "COMPLETED",
        "dd093@uok.ac.uk");
    bookingSystem.addBookingSpecial(
        bookingSystem.bookableRooms.get(1),
        bookingSystem.assistantOnShift.get(2),
        "SCHEDULED",
        "kja762@uok.ac.uk");

    int yes = 0;
    do {
      Scanner scnr = new Scanner(System.in);
      display_menu();
      int userChoice = Integer.parseInt(scnr.nextLine());
      switch (userChoice) {
        case -1:
          System.exit(1);
        case 0:
          break;
        case 1:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println(bookingSystem.showBookableRooms());
          System.out.println("0. Back to main menu.");
          System.out.println("-1. Quit application\n");
          int exitCase1 = scnr.nextInt();
          switch (exitCase1) {
            case 0:
              break;
            case -1:
              System.exit(1);
          }
          break;
        case 2:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println("Adding bookable room");
          System.out.println(universityResources.printRooms());
          System.out.println("Please enter one of the following: \n");
          System.out.println(
              "The sequential ID listen to a room, a date (dd/mm/yyyy), and a time (HH:MM) ");
          System.out.println("separated by a whitespace. ");
          String[] bookableRoomVariables = scnr.nextLine().split(" ");
          if (Integer.parseInt(bookableRoomVariables[0]) - 11
              < bookingSystem.bookableRooms.size()) {
            bookingSystem.addBookableRoom(
                universityResources.getRoom(Integer.parseInt(bookableRoomVariables[0]) - 11),
                bookableRoomVariables[1],
                bookableRoomVariables[2],
                0);
            System.out.println("Bookable Room added successfully: ");
            System.out.println(
                bookingSystem
                    .bookableRooms
                    .get(bookingSystem.bookableRooms.size() - 1)
                    .printBookableRoom());
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase2 = scnr.nextInt();
            switch (exitCase2) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } else {
            System.out.println("Error!");
            System.out.println(
                "You must enter a valid room code from the list of rooms, and a valid date and time between 7:00 and 9:00");
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID listen to a room, a date (dd/mm/yyyy), and a time (HH:MM), ");
            System.out.println("separated by a whitespace. ");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase2a = scnr.nextInt();
            switch (exitCase2a) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 3:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println(bookingSystem.showEmptyBookableRooms());
          System.out.println("Removing bookable room\n");
          System.out.println("Please, enter one of the following: \n");
          System.out.println("The sequential ID to select the bookable room to be removed.");
          int removeBookableRoomIndex = scnr.nextInt();
          int result = 0;
          bookingSystem.showEmptyBookableRoomsList();
          for (int i = 0; i < bookingSystem.bookableRooms.size(); i++) {
            if (bookingSystem
                .bookableRooms
                .get(i)
                .printBookableRoom()
                .equals(
                    bookingSystem
                        .emptyBRooms
                        .get(removeBookableRoomIndex - 11)
                        .printBookableRoom())) {
              result = i;
            }
          }
          if (result >= 0) {
            System.out.println("University of Knowledge - COVID test \n");
            System.out.println("Bookable Room removed successfully: ");
            System.out.println(bookingSystem.bookableRooms.get(result).printBookableRoom());
            bookingSystem.removeBookableRoom(result);
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase2b = scnr.nextInt();
            switch (exitCase2b) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } else {
            System.out.println("Error!");
            System.out.println("You must enter a valid index");
            System.out.println("Please, enter one of the following: \n");
            System.out.println("The sequential ID to select the bookable room to be removed.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase2c = scnr.nextInt();
            switch (exitCase2c) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 4:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println(bookingSystem.showAssistantsOnShift());
          System.out.println("0. Back to main menu.");
          System.out.println("-1. Quit application\n");
          int exitCase3a = scnr.nextInt();
          switch (exitCase3a) {
            case 0:
              break;
            case -1:
              System.exit(1);
          }
          break;
        case 5:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println("Adding assistant on shift \n");
          System.out.println(universityResources.printAssistants1());
          System.out.println("Please, enter one of the following: \n");
          System.out.println(
              "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a whitespace");
          String[] assistantOnShiftInputInfo = scnr.nextLine().split(" ");
          if (Integer.parseInt(assistantOnShiftInputInfo[0]) - 11
              < bookingSystem.assistantOnShift.size()) {
            bookingSystem.addAssistantShift(
                universityResources.getAssistant(
                    Integer.parseInt(assistantOnShiftInputInfo[0]) - 11),
                assistantOnShiftInputInfo[1],
                "FREE");
            System.out.println("Assistant on Shift added successfully: ");
            System.out.println(
                bookingSystem
                    .assistantOnShift
                    .get(Integer.parseInt(assistantOnShiftInputInfo[0]) - 11)
                    .printTemplate());
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase3b = scnr.nextInt();
            switch (exitCase3b) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } else {
            System.out.println("Error!");
            System.out.println("Make sure you have entered a valid ID and date");
            System.out.println("Implement the rest of this ASAP\n");
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a whitespace");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase3c = scnr.nextInt();
            switch (exitCase3c) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 6:
          int result2 = 0;
          System.out.println("University of Knowledge - COVID test\n");
          System.out.println(bookingSystem.showFreeAssistantsOnShift());
          System.out.println("Removing assistant on shift \n");
          System.out.println("Please, enter one of the following: \n");
          System.out.println("The sequential ID to select the assistant on shift to be removed");
          int assistantsOnShiftRemoveInput = scnr.nextInt();
          bookingSystem.showFreeAssistantsOnShiftList();
          try {
            result2 =
                bookingSystem.assistantOnShift.indexOf(
                    bookingSystem.emptyAssistantsOnShift.get(assistantsOnShiftRemoveInput - 11));
            System.out.println(result2);
            String saved1 = bookingSystem.assistantOnShift.get(result2).printTemplate();
            bookingSystem.assistantOnShift.remove(result2);
            System.out.println("Assistant on shift removed successfully: ");
            System.out.println(saved1);
            System.out.println("Please, enter one of the following: \n");
            System.out.println("The sequential ID to select the assistant on shift to be removed");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase4b = scnr.nextInt();
            switch (exitCase4b) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } catch (Exception e) {
            System.out.println("Error!");
            System.out.println("Make sure you have entered a valid ID");
            System.out.println("Please, enter one of the following: \n");
            System.out.println("The sequential ID to select the assistant on shift to be removed");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase4c = scnr.nextInt();
            switch (exitCase4c) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 7:
          System.out.println("University of Knowledge - COVID test\n");
          System.out.println("Select which booking to list: ");
          System.out.println("1. All");
          System.out.println("2. Only bookings status: SCHEDULED");
          System.out.println("3. Only bookings status: COMPLETED");
          int ch = scnr.nextInt();
          switch (ch) {
            case 1:
              System.out.println(bookingSystem.printBookings());
              System.out.println("0. Back to main menu.");
              System.out.println("-1. Quit application\n");
              int exitCase5a = scnr.nextInt();
              switch (exitCase5a) {
                case 0:
                  break;
                case -1:
                  System.exit(1);
              }
              break;
            case 2:
              System.out.println(bookingSystem.printScheduledBookings());
              System.out.println("0. Back to main menu.");
              System.out.println("-1. Quit application\n");
              int exitCase5a1 = scnr.nextInt();
              switch (exitCase5a1) {
                case 0:
                  break;
                case -1:
                  System.exit(1);
              }
              break;
            case 3:
              System.out.println(bookingSystem.printCompletedBookings());
              System.out.println("0. Back to main menu.");
              System.out.println("-1. Quit application\n");
              int exitCase5a2 = scnr.nextInt();
              switch (exitCase5a2) {
                case 0:
                  break;
                case -1:
                  System.exit(1);
              }
              break;
            default:
              break;
          }
          break;
        case 8:
          System.out.println("University of Knowledge - COVID test \n");
          System.out.println("Adding bookings (appointment for a COVID test) to the system \n");
          String z = bookingSystem.crossCheck();
          System.out.println(z);
          System.out.println("Please, enter one of the following: \n");
          System.out.println(
              "The sequential ID of an available time-slot and the student email, separated by a white space.");
          bookingSystem.crossCheckList();
          String[] bookingsInputInfo = scnr.nextLine().split(" ");
          try {
            System.out.println("Booking added successfully:");
            bookingSystem.addBooking(
                bookingSystem.getBookableRoom(Integer.parseInt(bookingsInputInfo[0]) - 11),
                bookingSystem.getAssistontOnShift(Integer.parseInt(bookingsInputInfo[0]) - 11),
                "SCHEDULED",
                bookingsInputInfo[1]);
            System.out.println(
                bookingSystem.bookings.get(bookingSystem.bookings.size() - 1).printTemplate());
            System.out.println("List of available time-slots: ");
            System.out.println(z);
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID of an available time-slot and the student email, separated by a white space.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase6a = scnr.nextInt();
            switch (exitCase6a) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(
                "Please make sure you enter the correct ID and a valid, University of Knowledge email (@uok.ac.uk)\n");
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID of an available time-slot and the student email, separated by a white space.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase6b1 = scnr.nextInt();
            switch (exitCase6b1) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 9:
          System.out.println("University of Knowledge - COVID test\n");
          System.out.println(bookingSystem.printScheduledBookings());
          System.out.println("Removing booking from the system");
          System.out.println("Please, enter one of the following: \n");
          System.out.println(
              "The sequential ID to select the booking to be removed from the listed bookings above. ");
          int bookingsRemoveInfo = scnr.nextInt();
          try {
            String savedVar = bookingSystem.getBooking(bookingsRemoveInfo - 11).printTemplate();
            bookingSystem.removeBooking(bookingSystem.getBooking(bookingsRemoveInfo - 11));
            System.out.println("Booking removed successfully:");
            System.out.println(savedVar);
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID to select the booking to be removed from the listed bookings above.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase7a = scnr.nextInt();
            switch (exitCase7a) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } catch (Exception e) {
            System.out.println("Error!");
            System.out.println("Please enter a valid sequential ID from the list");
            System.out.println("Please, enter one of the following: \n");
            System.out.println(
                "The sequential ID to select the booking to be removed from the listed bookings above.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase7b = scnr.nextInt();
            switch (exitCase7b) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
        case 10:
          System.out.println("University of Knowledge - COVID test\n");
          System.out.println(bookingSystem.printScheduledBookings());
          System.out.println("Conclude booking \n");
          System.out.println("Please, enter one of the following: \n");
          System.out.println("The sequential ID to select the booking to be completed.");
          int bookingsConcludeInfo = scnr.nextInt();
          try {
            System.out.println("Booking completed successfully:");
            bookingSystem.concludeBooking(bookingSystem.getBooking(bookingsConcludeInfo - 11));
            System.out.println(
                bookingSystem.bookings.get(bookingSystem.bookings.size() - 1).printTemplate());
            System.out.println("Please, enter one of the following: \n");
            System.out.println("The sequential ID to select the booking to be completed.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase7c = scnr.nextInt();
            switch (exitCase7c) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          } catch (Exception e) {
            System.out.println("Error!");
            System.out.println("Please enter a valid sequential ID from the list");
            System.out.println("Please, enter one of the following");
            System.out.println("The sequential ID to select the booking to be completed.");
            System.out.println("0. Back to main menu.");
            System.out.println("-1. Quit application\n");
            int exitCase7d = scnr.nextInt();
            switch (exitCase7d) {
              case 0:
                break;
              case -1:
                System.exit(1);
            }
            break;
          }
      }
    } while (yes == 0);
  }
}
