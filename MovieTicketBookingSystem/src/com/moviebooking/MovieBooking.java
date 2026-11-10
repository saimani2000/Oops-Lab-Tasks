
package com.moviebooking;

import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MovieBooking {

    static Scanner sc = new Scanner(System.in);

    // 6 Rows and 10 Seats
    static boolean[][] seats = new boolean[6][10];

    static String movieName = "Jailer 2";

    static int weekdayPrice = 200;
    static int weekendPrice = 250;

    static double totalRating = 0;
    static int ratingCount = 0;

    public static void main(String[] args) {

        int choice;

        System.out.println("======================================");
        System.out.println("       MOVIE TICKET BOOKING SYSTEM");
        System.out.println("======================================");

        do {

            System.out.println("\nMovie Name: " + movieName);

            System.out.println("\n1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Apply Discount Coupon");
            System.out.println("5. Movie Rating");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showSeats();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    applyCoupon();
                    break;

                case 5:
                    movieRating();
                    break;

                case 6:
                    System.out.println("Thank you for visiting our theatre!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // 1. Show Available Seats

    static void showSeats() {

        System.out.println("\n========== JAILER 2 SEAT ARRANGEMENT ==========");
        System.out.println("M = Available | K = Booked");

        for (int i = 0; i < seats.length; i++) {

            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == true) {

                    System.out.print(" K ");

                } else {

                    System.out.print(" M ");
                }
            }

            System.out.println();
        }
    }

    // 2. Book Ticket

    static void bookTicket() {

        showSeats();

        System.out.print("\nEnter number of tickets: ");
        int numberOfTickets = sc.nextInt();

        if (numberOfTickets <= 0 || numberOfTickets > 60) {

            System.out.println("Invalid number of tickets!");
            return;
        }

        int ticketPrice = getTicketPrice();

        int totalAmount = 0;

        for (int i = 1; i <= numberOfTickets; i++) {

            System.out.println("\nSelect seat " + i);

            System.out.print("Enter row number (1-6): ");
            int row = sc.nextInt();

            System.out.print("Enter seat number (1-10): ");
            int seat = sc.nextInt();

            if (row < 1 || row > 6 || seat < 1 || seat > 10) {

                System.out.println("Invalid seat! Please try again.");

                i--;
                continue;
            }

            if (seats[row - 1][seat - 1] == true) {

                System.out.println("Sorry! This seat is already booked.");

                i--;
                continue;

            } else {

                seats[row - 1][seat - 1] = true;

                totalAmount = totalAmount + ticketPrice;

                System.out.println("Seat booked successfully!");
            }
        }

        System.out.println("\n========== BOOKING DETAILS ==========");

        System.out.println("Movie Name: " + movieName);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Ticket Price: Rs." + ticketPrice);
        System.out.println("Total Amount: Rs." + totalAmount);

        System.out.println("Booking completed successfully!");
    }

    // 3. Cancel Ticket

    static void cancelTicket() {

        showSeats();

        System.out.print("\nEnter row number: ");
        int row = sc.nextInt();

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        if (row < 1 || row > 6 || seat < 1 || seat > 10) {

            System.out.println("Invalid seat selection!");
            return;
        }

        if (seats[row - 1][seat - 1] == true) {

            seats[row - 1][seat - 1] = false;

            System.out.println("Ticket cancelled successfully!");

        } else {

            System.out.println("This seat is not booked!");
        }
    }

    // 4. Apply Discount Coupon

    static void applyCoupon() {

        System.out.print("\nEnter ticket amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {

            System.out.println("Invalid ticket amount!");
            return;
        }

        System.out.print("Enter coupon code: ");
        String coupon = sc.next();

        double discount = 0;

        if (coupon.equalsIgnoreCase("MOVIE10")) {

            discount = amount * 0.10;

        } else if (coupon.equalsIgnoreCase("MOVIE20")) {

            discount = amount * 0.20;

        } else {

            System.out.println("Invalid coupon code!");
        }

        double finalAmount = amount - discount;

        System.out.println("\n========== PAYMENT DETAILS ==========");

        System.out.println("Original Amount: Rs." + amount);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Amount: Rs." + finalAmount);
    }

    // 5. Weekend Pricing

    static int getTicketPrice() {

        LocalDate today = LocalDate.now();

        DayOfWeek day = today.getDayOfWeek();

        if (day == DayOfWeek.SATURDAY ||
            day == DayOfWeek.SUNDAY) {

            System.out.println("\nWeekend Pricing Applied!");
            System.out.println("Ticket Price: Rs." + weekendPrice);

            return weekendPrice;

        } else {

            System.out.println("\nWeekday Pricing Applied!");
            System.out.println("Ticket Price: Rs." + weekdayPrice);

            return weekdayPrice;
        }
    }

    // 6. Movie Rating

    static void movieRating() {

        System.out.println("\nMovie Name: " + movieName);

        System.out.print("Enter your rating (1-5): ");
        int rating = sc.nextInt();

        if (rating >= 1 && rating <= 5) {

            totalRating = totalRating + rating;

            ratingCount++;

            double averageRating = totalRating / ratingCount;

            System.out.println("\nThank you for rating the movie!");

            System.out.println("Your Rating: " + rating + "/5");

            System.out.println("Average Movie Rating: "
                    + averageRating + "/5");

            System.out.println("Total Ratings: " + ratingCount);

        } else {

            System.out.println("Invalid rating! Enter between 1 and 5.");
        }
    }
}
