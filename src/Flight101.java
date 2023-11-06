import java.time.LocalDate;
import java.util.Scanner;

public class Flight101 {
    static String fullName = "", birthday = "", dateOfFlight = "";
    static byte totalPassengers = 0;
    static Scanner scannerObject = new Scanner(System.in);

    public static String Checkout(String fname, byte x) {
        float total = 2345.10F * x;
        scannerObject.close();
        return "Thank you, (" + fname + ") for choosing Flight 101. Your total amount to pay for " + x + " is " + total + ". Please present this to the cashier for payment. Have a safe flight!";
    }

    public static void setBookingInformation() {
        System.out.println("Welcome to Flight 101");
        System.out.println("Please provide your information below");
        System.out.print("Full Name: ");
        fullName = scannerObject.nextLine();

        System.out.print("Birthday (00-00-0000): ");
        birthday = scannerObject.nextLine();

        System.out.print("Date of Flight (00-00-0000): ");
        dateOfFlight = scannerObject.nextLine();

        System.out.print("Total passenger(s): ");
        totalPassengers = Byte.parseByte(scannerObject.nextLine());
        System.out.println("\n \n \n \n \n");
        getBookingInformation(fullName, birthday, dateOfFlight, totalPassengers);
    }

    public static void getBookingInformation(String fullName, String bday, String dateofflight, byte totalpassengers) {
        String[] splitName = fullName.split("\\.");
        String answer;
        StringBuilder firstName = new StringBuilder();
        int age = LocalDate.now().getYear() - Integer.parseInt(bday.substring(bday.lastIndexOf("-") + 1));
        String lastName = splitName[1].trim();
        char middleInitial = fullName.charAt(fullName.indexOf(".") - 1);
        int indexOfDot = fullName.indexOf(".");

        for (int i = 0; i < indexOfDot - 1; i++) {
            if (fullName.charAt(i) != ' ') {
                firstName.append(fullName.charAt(i));
            }
        }

        System.out.println("First Name: " + firstName.toString().trim());
        System.out.println("Middle Initial: " + middleInitial);
        System.out.println("Last Name: " + lastName);
        System.out.println("Birthday: " + age);
        System.out.println("Date of Flight: " + dateofflight);
        System.out.println("Total Passenger(s): " + totalpassengers);
        System.out.println(bday);
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Kindly press \"Y\" for check out or \"N\" to change information.");
        answer = scannerObject.next();
        if (answer.equalsIgnoreCase("n")) {
            setBookingInformation();

        }
        else if (answer.equalsIgnoreCase("y")) {
            System.out.println(Checkout(firstName.toString(), totalpassengers));
        }
        else {
            setBookingInformation();
        }
        scannerObject.close();
    }

    public static void main(String[] args) {
        setBookingInformation();
    }
}
