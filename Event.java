import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {

    //LocalDate today = LocalDate.now();
    Scanner sc = new Scanner(System.in);

    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private ArrayList<Attendee> eventAttendees = new ArrayList<>();

    public ArrayList<Attendee> getEventAttendees() {
        return eventAttendees;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate){
        this.eventDate = eventDate;
    }

    //ArrayList<String> eventAttendees = new ArrayList<>();

    public void organizeEvent(){

        while (true) {
        System.out.println("===Here's what you can do in the program===");
        System.out.println("Type 1 to enter event details:");
        System.out.println("Type 2 to enter attendee names that are coming to the event:");
        System.out.println("Type 3 to remove an attendee from the list:");
        System.out.println("Type 4 to update an attendee in the list:");
        System.out.println("Type 5 to search for an attendee in the list:");
        System.out.println("Type 6 to display all the attendees from the event:");
        System.out.println("Type 7 to end:");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                eventDetails();
                break;
            case 2:
                addEventAttendee();
                break;
            case 3:
                removeEventAttendee();
                break;
            case 4:
                updateEventAttendee();
                break;
            case 5:
                searchEventAttendee();
                break;
            case 6:
                displayAllAttendee();
                break;
            case 7:
                return;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    }

    private void eventDetails(){
        System.out.println("Please enter eventID");
        setEventID(sc.nextLine());
        System.out.println("Please enter eventName");
        setEventName(sc.nextLine());
        System.out.println("Please enter eventDate(YYYY-MM-DD)");
        LocalDate date = LocalDate.parse(sc.nextLine());
        setEventDate(date);
        System.out.println("Please enter eventVenue");
        setEventVenue(sc.nextLine());
    }

    private void addEventAttendee(){
        System.out.println("How many attendees are coming?");
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            Attendee att = new Attendee();

            System.out.println("Enter the name of the attendee");
            String name = sc.nextLine();
            att.setName(name);

            System.out.println("Enter the gender of the attendee");
            String gender = sc.nextLine();
            att.setGender(gender.charAt(0));

            System.out.println("Enter the email of the attendee");
            String email = sc.nextLine();
            att.setEmail(email);

            System.out.println("Enter the age of the attendee");
            int age =sc.nextInt();
            sc.nextLine();
            att.setAge(age);
            System.out.println("-------------------------");

            eventAttendees.add(att);
        }
    }

    private void removeEventAttendee(){
        System.out.println("Enter the name of the attendee to remove");
        String nameToRemove = sc.nextLine();

        for(Attendee att : eventAttendees){
            if(nameToRemove.equals(att.getName())){
                eventAttendees.remove(att);
                return;
            }
        }

        System.out.println("The name you entered does not exist");
    }

    private void updateEventAttendee(){
        System.out.println("Enter the name of attendee to update");
        String nameToUpdate = sc.nextLine();

        for(Attendee att : eventAttendees){
            if(nameToUpdate.equals(att.getName())){
                while (true) {
                System.out.println("------------------");
                System.out.println("1.Update name");
                System.out.println("2.Update gender");
                System.out.println("3.Update email");
                System.out.println("4.Update age");
                System.out.println("5.End");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Please enter new name");
                        String newName = sc.nextLine();
                        att.setName(newName);
                        break;
                    case 2:
                        System.out.println("Please enter new gender");
                        String newGender = sc.nextLine();
                        att.setGender(newGender.charAt(0));
                        break;
                    case 3:
                        System.out.println("Please enter new email");
                        String newEmail = sc.nextLine();
                        att.setEmail(newEmail);
                        break;
                    case 4:
                        System.out.println("Please enter new age");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        att.setAge(newAge);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
        }

        System.out.println("There is no one by that name");
    }

    private void searchEventAttendee(){
        System.out.println("Enter the name of attendee to find");
        String findName = sc.nextLine();

        for(Attendee att : eventAttendees){
            if(findName.equals(att.getName())){
                System.out.println("----------------------------");
                System.out.println("name: " + att.getName());
                System.out.println("gender: " + att.getGender());
                System.out.println("email: " + att.getEmail());
                System.out.println("age: " + att.getAge());
                System.out.println("----------------------------");
                return;
            }
        }
        System.out.println("There is no one by that name");
    }

    private void displayAllAttendee(){
        System.out.println("Here is the list of attendees");
        System.out.println("-------------------------");
        for(Attendee att : eventAttendees){
            System.out.println("name: " + att.getName());
            System.out.println("gender: " + att.getGender());
            System.out.println("email: " + att.getEmail());
            System.out.println("age: " + att.getAge());
            System.out.println("-------------------------");
        }
    }
        
    public String toString() {
        return 
            "-------------------------------" + "\n" +
            "Event:" + "\n" +
            "Event ID = " + eventID + "\n" +
            "Event name = " + eventName + "\n" +
            "Event venue = " + eventVenue + "\n" +
            "Event date = " + eventDate + "\n" +
            "The number of Event attendees = " + eventAttendees.size() + "\n" +
            "--------------------------------" ;
    }

}
