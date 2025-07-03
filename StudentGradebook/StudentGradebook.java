import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradebook {
    private static Map<String, Double> gradebook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Gradebook Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Grade");
            System.out.println("3. View Grades");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateGrade(scanner);
                    break;
                case 3:
                    viewGrades();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Gradebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Add a student and their grade
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if (gradebook.containsKey(name)) {
            System.out.println("Student already exists.");
        } else {
            System.out.print("Enter grade (0 - 100): ");
            double grade = scanner.nextDouble();
            gradebook.put(name, grade);
            System.out.println("Student added.");
        }
    }

    // Update an existing student's grade
    private static void updateGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if (gradebook.containsKey(name)) {
            System.out.print("Enter new grade: ");
            double grade = scanner.nextDouble();
            gradebook.put(name, grade);
            System.out.println("Grade updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // View all students and their grades
    private static void viewGrades() {
        if (gradebook.isEmpty()) {
            System.out.println("No students in the gradebook.");
        } else {
            System.out.println("\n--- All Grades ---");
            for (Map.Entry<String, Double> entry : gradebook.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Calculate average grade
    private static void calculateAverage() {
        if (gradebook.isEmpty()) {
            System.out.println("No grades to calculate average.");
        } else {
            double total = 0;
            for (double grade : gradebook.values()) {
                total += grade;
            }
            double average = total / gradebook.size();
            System.out.println("Average Grade: " + average);
        }
    }
}
