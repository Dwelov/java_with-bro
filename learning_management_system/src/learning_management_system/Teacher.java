package learning_management_system;

import java.util.Scanner;

public class Teacher extends User {

    public Teacher(String id, String name, String role) {
        super(id, name, role);
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("   Teacher Menu - Welcome " + getName());
            System.out.println("-".repeat(40));
            System.out.println("1. Login");
            System.out.println("2. Add Course");
            System.out.println("3. Post Assignment");
            System.out.println("4. Assign Grades");
            System.out.println("5. Display Results");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    postAssignment();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    displayResults();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    // Placeholder methods (to be implemented later)
    public void createCourse() {
        System.out.println(">> Course creation logic goes here.");
    }

    public void postAssignment() {
        System.out.println(">> Assignment posting logic goes here.");
    }

    public void assignGrade() {
        System.out.println(">> Grade assignment logic goes here.");
    }

    public void displayResults() {
        System.out.println(">> Results display logic goes here.");
    }
    
}