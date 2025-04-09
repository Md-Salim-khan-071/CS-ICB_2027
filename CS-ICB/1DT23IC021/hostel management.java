import java.util.Scanner;

public class HostelManagement {
    static String[] rooms = new String[5]; // 5 hostel rooms

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hostel Management Menu ---");
            System.out.println("1. View Rooms");
            System.out.println("2. Check-In Student");
            System.out.println("3. Check-Out Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> checkIn(input);
                case 3 -> checkOut(input);
                case 4 -> System.out.println("Exiting Hostel Management System. Goodbye!");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        input.close();
    }

    static void viewRooms() {
        System.out.println("\n--- Room Status ---");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null)
                System.out.println("Room " + (i + 1) + ": Empty");
            else
                System.out.println("Room " + (i + 1) + ": Occupied by " + rooms[i]);
        }
    }

    static void checkIn(Scanner input) {
        System.out.print("Enter room number (1-5): ");
        int room = input.nextInt();
        input.nextLine();

        if (room < 1 || room > 5) {
            System.out.println("Invalid room number.");
        } else if (rooms[room - 1] != null) {
            System.out.println("Room is already occupied.");
        } else {
            System.out.print("Enter student name: ");
            String name = input.nextLine();
            rooms[room - 1] = name;
            System.out.println("Student checked in successfully.");
        }
    }

    static void checkOut(Scanner input) {
        System.out.print("Enter room number (1-5): ");
        int room = input.nextInt();
        input.nextLine();

        if (room < 1 || room > 5) {
            System.out.println("Invalid room number.");
        } else if (rooms[room - 1] == null) {
            System.out.println("Room is already empty.");
        } else {
            rooms[room - 1] = null;
            System.out.println("Student checked out successfully.");
        }
    }
}
