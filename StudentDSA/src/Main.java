import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement student = new StudentManagement();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by ID (Bubble sort)");
            System.out.println("5. Sort Students by Mark (Insertion sort)");
            System.out.println("6. Search Student");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 8) {
                        throw new IllegalArgumentException("Invalid choice. Please enter a number between 1-0.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    String id;
                    while (true) {
                        System.out.print("Enter Student ID: ");
                        if (scanner.hasNextInt()) {
                            id = scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid input. Student ID must be an integer. Please try again.");
                            scanner.next();
                        }
                    }

                    scanner.nextLine();
                    String name;
                    while (true) {
                        System.out.print("Enter Student Name: ");
                        name = scanner.nextLine();
                        if (name.matches("^[a-zA-Z\\s]+$")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Name cannot contain numbers or special characters. Please try again.");
                        }
                    }

                    double mark = 0.0;
                    while (true) {
                        System.out.print("Enter Student Marks (0.0 - 10.0): ");
                        if (scanner.hasNextDouble()) {
                            mark = scanner.nextDouble();
                            if (mark >= 0.0 && mark <= 10.0) {
                                break;
                            } else {
                                System.out.println("Marks must be between 0.0 and 10.0. Please try again.");
                            }
                        } else {
                            System.out.println("Invalid input. Marks must be a numeric value. Please try again.");
                            scanner.next();
                        }
                    }
                    student.addStudent(new Students(id, name, mark));
                    break;
                case 2:
                    try {
                        System.out.print("Enter Student ID to Edit: ");
                        if (!scanner.hasNextInt()) {
                            throw new IllegalArgumentException("Invalid input.");
                        }
                        id = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        try {
                            name = scanner.nextLine();
                            if (name.matches(".*\\d.*")) {
                                throw new IllegalArgumentException("Name cannot contain numbers. Please enter a valid name.");
                            }
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        name = scanner.nextLine();
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = scanner.nextLine();
                            if (name.matches("^[a-zA-Z\\s]+$")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Name cannot contain numbers or special characters. Please try again.");
                            }
                        }
                        mark = scanner.nextDouble();
                        student.editStudent(id, name, mark);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    id = scanner.nextLine();
                    student.deleteStudent(id);
                    break;
                case 4:
                    System.out.println("Students sorted by ID using Bubble Sort.");
                    student.bubbleSortStudentsById();
                    break;
                case 5:
                    System.out.println("Students sorted by Mark using Insertion Sort.");
                    student.insertionSortStudentsByMark();
                    break;
                case 6:
                    System.out.print("Enter Student ID to Search: ");
                    id = scanner.nextLine();
                    Students students = student.searchStudent(id);
                    System.out.println(students != null ? students : "Student not found.");
                    break;
                case 7:
                    student.displayStudents();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}