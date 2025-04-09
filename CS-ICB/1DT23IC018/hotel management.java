import java.util.Scanner;

public class HotelManagement {
    static String[] rooms = new String[5]; // 5 rooms for simplicity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hotel Management Menu ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Check-In");
            System.out.println("3. Check-Out");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> checkIn(scanner);
                case 3 -> checkOut(scanner);
                case 4 -> System.out.println("Thank you for using Hotel Management System.");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static void viewRooms() {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null)
                System.out.println("Room " + (i + 1) + " is Empty.");
            else
                System.out.println("Room " + (i + 1) + " is occupied by " + rooms[i]);
        }
    }

    static void checkIn(Scanner scanner) {
        System.out.print("Enter room number (1-5): ");
        int room = scanner.nextInt();
        scanner.nextLine();
        if (room < 1 || room > 5) {
            System.out.println("Invalid room number.");
        } else if (rooms[room - 1] != null) {
            System.out.println("Room already occupied.");
        } else {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();
            rooms[room - 1] = name;
            System.out.println("Check-in successful.");
        }
    }

    static void checkOut(Scanner scanner) {
        System.out.print("Enter room number (1-5): ");
        int room = scanner.nextInt();
        scanner.nextLine();
        if (room < 1 || room > 5) {
            System.out.println("Invalid room number.");
        } else if (rooms[room - 1] == null) {
            System.out.println("Room is already empty.");
        } else {
            rooms[room - 1] = null;
            System.out.println("Check-out successful.");
        }
    }
}
