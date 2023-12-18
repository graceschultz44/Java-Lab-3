// Grace Schultz
// 48761302
// Lab 4-Fall 2022

import java.util.Scanner; // import scanner
public class SeatReservation {
    static Scanner input = new Scanner(System.in);
	public static void main(String[] args) { // main method creates arrays, asks about reservations, and prints subtotal
        String[] rowASeats = {"1A", "2A", "3A"};
        String[] rowBSeats = {"1B", "2B", "3B"};
        double[] rowAPrices = {99.99, 110.99, 99.99};
        double[] rowBPrices = {75.99, 85.99, 75.99};
        double total = 0;
        display(rowASeats, rowBSeats, rowAPrices, rowBPrices);
        int numSeats;
        System.out.println("How many seats do you want to reserve?");
        numSeats = input.nextInt();
        for(int i = 0; i < numSeats; i++) {
            String s = getRow(input);
            if (s.equalsIgnoreCase("A")) {
                total += makeReservation(rowASeats, rowAPrices, s, input);
            }
            else if(s.equalsIgnoreCase("B")) {
                total += makeReservation(rowBSeats, rowBPrices, s, input);
            }
            System.out.println("===================================");
            System.out.printf("Your subtotal is: $%.2f\n", total);
            System.out.println("-----");
        }
        printReceipt(numSeats, total);
    }
    public static void display(String[] rowASeats, String[] rowBSeats, double[] rowAPrices, double[] rowBPrices) {
        // display method displays the seating chart
        System.out.println("Welcome to our event! Here's out seating chart with prices:");
        System.out.println("Seating Chart");
        System.out.println("===================================");
        printRowSeats(rowASeats);
        printRowPrices(rowAPrices);
        System.out.println("-----------------------------------");
        printRowSeats(rowBSeats);
        printRowPrices(rowBPrices);
        System.out.println("===================================");

    }
    public static void printRowSeats(String[] rowSeats) { // prints the rowSeats
        System.out.print("|");
        for (int i = 0; i < rowSeats.length; i++) {
            System.out.printf("%-11s", rowSeats[i]);
        }
        System.out.println("|");
    }
    public static void printRowPrices(double[] rowPrices) { // prints the rowPrices
        System.out.print("|");
        for (double rowPrice : rowPrices) {
            System.out.printf("$%-10.2f", rowPrice);
        }
        System.out.println("|");
    }
    public static String getRow(Scanner scan) { // asks the user which row they want to reserve
        System.out.print("Enter the row for the seat you want to reserve: (A/B)");
        String row = input.next();
        System.out.println("===================================");
        return row;

    }
    public static double makeReservation(String[] rowSeats, double[] prices, String row, Scanner scan) {
        // asks the useer which seat number they want, let's them know what seat the selected and the price
        printRowSeats(rowSeats);
        printRowPrices(prices);
        System.out.println("===================================");
        System.out.println("Which seat number do you want?");
        int seatNum = scan.nextInt();
        System.out.printf("The seat you selected is: %d%s\n", seatNum, row);
        System.out.printf("The price of the seat is: $%.2f\n", prices[seatNum-1]);

        updateSeatingChart(rowSeats, seatNum); // calls update seating chart
        printRowSeats(rowSeats);
        printRowPrices(prices);
        return prices[seatNum-1];
    }
    public static void updateSeatingChart(String[] rowSeats, int seatNum) {
        // updates the seating chart and puts an X in the chosen spot
        System.out.println("Updated row chart:");
        System.out.println("===================================");
        rowSeats[seatNum-1] = "X";

    }
    public static void printReceipt(int numSeats, double total) {
        // prints the final receipt including fees, taxes, and total
        double fees = (numSeats * 14.99);
        double taxes = ((total + fees) * 0.0825);
        double grandTotal = total + fees + taxes;
        System.out.println("Thank you for reserving with us. Here's your receipt:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Subtotal: $%.2f\n", total);
        System.out.printf("Fees: 2 x $14.99 = $%.2f\n", fees);
        System.out.printf("Taxes: $%.2f\n", taxes);
        System.out.println("=====================================================");
        System.out.printf("Total: $%.2f\n", grandTotal);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}