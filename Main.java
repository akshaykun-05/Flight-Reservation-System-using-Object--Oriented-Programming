// Passenger Class
class Passenger {
    private int id;
    private String name;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Flight Class
class Flight {
    // Constant representing total seat capacity
    private final int MAX_SEATS;
    private Passenger[] seats;

    // Constructor to initialize capacity and the seat array
    public Flight(int maxSeats) {
        this.MAX_SEATS = maxSeats;
        this.seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.\n");
    }

    // Method to handle booking logic and validation
    public boolean bookSeat(Passenger p) {
        // Step 1: Prevent duplicate booking
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == p.getId()) {
                System.out.println("Booking failed: Passenger " + p.getName() + " is already booked.");
                return false;
            }
        }

        // Step 2: Find available seat and book
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p; // Assign passenger to the first empty seat
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }

        // Step 3: Handle flight full scenario
        System.out.println("Flight Full! Booking failed for Passenger: " + p.getName());
        return false;
    }

    // Method to display current status of all seats
    public void displaySeatStatus() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < MAX_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            if (seats[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println(seats[i].getName());
            }
        }
        System.out.println();
    }
}

// Main Class for Testing
public class Main {
    public static void main(String[] args) {
        // Create Flight object with 5 seats
        Flight flight = new Flight(5);

        // Create multiple Passenger objects
        Passenger p1 = new Passenger(101, "Aman");
        Passenger p2 = new Passenger(102, "Rahul");
        Passenger p3 = new Passenger(103, "Riya"); 

        // Book seats
        flight.bookSeat(p1);
        flight.bookSeat(p2);

        // Display current status
        flight.displaySeatStatus();

        // Fill remaining seats
        Passenger p4 = new Passenger(104, "Neha");
        Passenger p5 = new Passenger(105, "Karan");
        Passenger p6 = new Passenger(106, "Vikas");

        flight.bookSeat(p4);
        flight.bookSeat(p5);
        flight.bookSeat(p6); // This should fill the last seat (Seat 5)

        System.out.println(); // formatting line break

        // Attempt to book when flight is full
        flight.bookSeat(p3); 
    }
}