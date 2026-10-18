import java.util.Scanner;
import java.util.Random;

public class CabBookingChatbot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int choice;

        // Main menu loop
        while (true) {
            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using Cab Booking Chatbot!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }

            // Select cab type
            System.out.println("\nSelect Cab Type:");
            System.out.println("1. Auto - Rs. 12/km");
            System.out.println("2. Sedan - Rs. 18/km");
            System.out.println("3. SUV - Rs. 25/km");
            System.out.print("Enter cab choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Returning to main menu.");
                sc.next();
                continue;
            }

            int cabChoice = sc.nextInt();

            int rate;

            switch (cabChoice) {
                case 1:
                    rate = 12;
                    break;
                case 2:
                    rate = 18;
                    break;
                case 3:
                    rate = 25;
                    break;
                default:
                    System.out.println("Invalid cab choice!");
                    continue;
            }

            // Display predefined routes
            System.out.println("\nAvailable Routes:");
            System.out.println("1. Pune Station to Shivajinagar - 5 km");
            System.out.println("2. Swargate to Kothrud - 8 km");
            System.out.println("3. Hinjawadi to Wakad - 10 km");
            System.out.print("Select route number: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Returning to main menu.");
                sc.next();
                continue;
            }

            int routeChoice = sc.nextInt();

            String source;
            String destination;
            int distance;

            switch (routeChoice) {
                case 1:
                    source = "Pune Station";
                    destination = "Shivajinagar";
                    distance = 5;
                    break;

                case 2:
                    source = "Swargate";
                    destination = "Kothrud";
                    distance = 8;
                    break;

                case 3:
                    source = "Hinjawadi";
                    destination = "Wakad";
                    distance = 10;
                    break;

                default:
                    System.out.println("Invalid route choice!");
                    continue;
            }

            // Calculate fare
            int fare = distance * rate;

            // Display booking details
            String cabType;

            if (cabChoice == 1) {
                cabType = "Auto";
            } else if (cabChoice == 2) {
                cabType = "Sedan";
            } else {
                cabType = "SUV";
            }

            System.out.println("\n===== BOOKING DETAILS =====");
            System.out.println("Source      : " + source);
            System.out.println("Destination : " + destination);
            System.out.println("Cab Type    : " + cabType);
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Rate        : Rs. " + rate + "/km");
            System.out.println("Total Fare  : Rs. " + fare);

            // Cancellation before OTP
            System.out.println("\nConfirm your booking:");
            System.out.println("1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Booking cancelled before OTP sharing.");
                sc.next();
                continue;
            }

            int confirmChoice = sc.nextInt();

            if (confirmChoice == 2) {
                System.out.println("Ride cancelled successfully.");
                System.out.println("No OTP has been shared.");
                continue;
            }

            if (confirmChoice != 1) {
                System.out.println("Invalid choice! Booking cancelled before OTP sharing.");
                continue;
            }

            // Generate a 4-digit OTP
            int otp = 1000 + random.nextInt(9000);

            System.out.println("\nBooking confirmed successfully!");
            System.out.println("Your 4-digit OTP is: " + otp);
            System.out.println("OTP shared with you successfully.");

            // Ride cannot be cancelled after OTP sharing
            System.out.println("Ride cancellation is now locked.");
            System.out.println("Your cab booking is complete.");
        }

        sc.close();
    }
}