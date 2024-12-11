import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree studentTree = new Tree();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Bubble Sort Students");
            System.out.println("7. Selection Sort Students");
            System.out.println("8. Exit");

            int choice = 0;
            while (true) {
                System.out.print("Choose an option: ");
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 8) {
                        throw new IllegalArgumentException("Invalid choice. Please enter a number between 1 and 8.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    int id = 0;
                    while (true) {
                        System.out.print("Enter Student ID: ");
                        if (scanner.hasNextInt()) {
                            id = scanner.nextInt();
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
                    studentTree.addStudent(new Student(id, name, mark));
                    break;

                case 2:
                    try {
                        System.out.print("Enter Student ID to Edit: ");
                        if (!scanner.hasNextInt()) {
                            throw new IllegalArgumentException("Invalid input.");
                        }
                        id = scanner.nextInt();
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
                        studentTree.editStudent(id, name, mark);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    id = scanner.nextInt();
                    studentTree.deleteStudent(id);
                    break;

                case 4:
                    while (true) {
                        try {
                            System.out.print("Enter Student ID to Search: ");
                            if (!scanner.hasNextInt()) {
                                throw new IllegalArgumentException("Invalid input.");
                            }
                            id = scanner.nextInt();
                            Student student = studentTree.searchStudent(id);
                            if (student != null) {
                                System.out.println(student);
                                break;
                            } else {
                                System.out.println("Student ID not found. Please try again.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Student List: ");
                    studentTree.displayStudents();
                    break;
                case 6:
                    System.out.println("Bubble Sort Student by ID: ");
                    studentTree.sortStudent();
                    break;
                case 7:
                    System.out.println("Selection sort Student by Name: ");
                    studentTree.sortStudentByName();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}