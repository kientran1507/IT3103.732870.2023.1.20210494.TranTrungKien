import java.util.Scanner;

public class DisplayDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a month (full name, abbreviation, 3 letters, or number): ");
            String monthInput = scanner.nextLine();
            
            System.out.print("Enter a year (non-negative, all digits): ");
            int year;
            try {
                year = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid year input. Please enter a non-negative number with all digits.");
                continue;
            }

            if (isValidMonth(monthInput) && year >= 0) {
                int month = getMonthNumber(monthInput);
                int days = getDaysInMonth(month, year);
                System.out.println("There are " + days + " days in " + monthInput + " " + year + ".");
                break;
            } else {
                System.out.println("Invalid month/year input. Please try again.");
            }
        }

        scanner.close();
    }

    public static boolean isValidMonth(String input) {
        String[] validMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
                                "Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec.",
                                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
                                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        for (String validMonth : validMonths) {
            if (input.equalsIgnoreCase(validMonth)) {
                return true;
            }
        }

        return false;
    }

    public static int getMonthNumber(String input) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] month3Letters = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",};
        String[] monthNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        for (int i = 0; i < monthNames.length; i++) {
            if (input.equalsIgnoreCase(monthNames[i]) || input.equalsIgnoreCase(monthAbbreviations[i]) || input.equalsIgnoreCase(monthNumbers[i]) || input.equalsIgnoreCase(month3Letters[i])) {
                return i + 1;
            }
        }

        return -1;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return daysInMonth[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
