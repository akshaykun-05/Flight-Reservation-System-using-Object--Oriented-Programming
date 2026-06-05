// ===== Passenger Data Model =====
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

// ===== Flight Booking Logic =====
class Flight {
    // Constant representing total seat capacity for this flight instance
    private final int MAX_SEATS;
    private Passenger[] seats;

    // Initialize the flight with a fixed number of seats
    public Flight(int maxSeats) {
        this.MAX_SEATS = maxSeats;
        this.seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.\n");
    }

    // Book the first available seat for a passenger, if possible.
    // Returns true when booking succeeds and false when the passenger is already booked or the flight is full.
    public boolean bookSeat(Passenger passenger) {
        // Prevent duplicate bookings by checking existing seat assignments.
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null && seats[i].getId() == passenger.getId()) {
                System.out.println("Booking failed: Passenger " + passenger.getName() + " is already booked.");
                return false;
            }
        }

        // Assign the passenger to the first empty seat found.
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = passenger; // Place passenger in an empty seat
                System.out.println("Passenger " + passenger.getName() + " booked successfully.");
                return true;
            }
        }

        // If no empty seat exists, the flight is full.
        System.out.println("Flight Full! Booking failed for Passenger: " + passenger.getName());
        return false;
    }

    // Print the current list of seats, marking each as either booked or empty.
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

    // Method to count how many seats are currently booked on the flight.
    public int getBookedSeatCount() {
        int count = 0;

        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null) {
                count++;
            }
        }

        return count;
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