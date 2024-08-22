import java.util.Scanner;
public class EVChargingStation { 
    public static void main(String[] args) {
        ChargingStation[] stations = {
            new ChargingStation("1", "Vizag", 5), // Use ChargingStation class
            new ChargingStation("2", "Hyderabad", 2),
            new ChargingStation("3", "Banglore", 10)
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Find Charging Stations");
            System.out.println("2. Book a Slot");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter location to search for: ");
                String location = scanner.nextLine();

                boolean found = false;
                for (ChargingStation station : stations) { 
                    if (station.location.equalsIgnoreCase(location)) {
                        System.out.println(station);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No charging stations found in " + location);
                }
            } else if (choice == 2) {
                System.out.print("Enter Charging Station ID to book: ");
                String id = scanner.nextLine();

                boolean found = false;
                for (ChargingStation station : stations) { 
                    if (station.id.equals(id)) {
                        station.bookSlot();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Charging Station not found.");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using the EV Charging Station Finder!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class ChargingStation {
    String id;
    String location;
    int availableSlots;

    ChargingStation(String id, String location, int availableSlots) { 
        this.id = id;
        this.location = location;
        this.availableSlots = availableSlots;
    }

    void bookSlot() {
        if (availableSlots > 0) {
            availableSlots--;
            System.out.println("Slot booked successfully at " + location);
        } else {
            System.out.println("No available slots at this location.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Location: " + location + ", Available Slots: " + availableSlots;
    }
}

