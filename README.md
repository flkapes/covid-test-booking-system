# covid-test-booking-system
## This is a COVID-19 test booking system I created for the University of Knowledge.

### It is coded using Java. It consists of multiple classes, they are:

  * Assistants: This class is responsible for creating an Assistants Object with the Name and Email of the Assistant.
  * Room: This class is responsible for creating a Room object with the Room Code and Room Capacity.
  * UniversityResources: This class is responsible for a list of Rooms and a list of Assistants, kind of an inventory of the University's static resources.
  * BookingSystem: This class is quite large and has a range of functionality including , adding, removing, updating, and printing everything from Assistants to Bookings
  * BookableRoom: This class uses the Room object to create a Bookable Room on a specific day and at a specific time.
  * AssistantOnShift: This class uses the Assistants object to create an AssistantOnShift at a specific date and at either 7:00, 8:00, or 9:00AM.
  * Bookings: This class uses an available or empty BookableRoom and a free AssistantOnShift to create a Booking.
  * BookingApp: The main method of this class pre-loads some input data and uses a set of swtich statments to allow the user to navigate using the Command Line Interface.


 
