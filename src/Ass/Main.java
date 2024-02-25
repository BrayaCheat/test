package Ass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static Ass.Employee.*;
public class Main {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Front-end Developer");
        skills.add("Back-end Developer");
        skills.add("Network Engineering");
        skills.add("Network Support");
        List<String> preferredShifts = new ArrayList<>();
        preferredShifts.add("Morning");
        preferredShifts.add("Afternoon");
        preferredShifts.add("Night");
        Employee[] employees = new Employee[20];
        employees[0] = new Employee(1, "Oeng Sovanpanha", skills.subList(1, 2), preferredShifts.subList(0,1) , 40, "Free");
        employees[1] = new Employee(2, "Lim Chetra", skills.subList(1, 2), preferredShifts.subList(1,2) , 30, "Free");
        employees[3] = new Employee(3, "Oum Stalin", skills.subList(1, 2), preferredShifts.subList(1,2) , 40, "Free");
        employees[4] = new Employee(4, "Cheat Braya", skills.subList(0, 1), preferredShifts.subList(2,3) , 30, "Free");
        employees[5] = new Employee(5, "Amma Emome", skills.subList(0, 1), preferredShifts.subList(0,1) , 40, "Free");
        employees[6] = new Employee(6, "Eh Pouthorng", skills.subList(0, 1), preferredShifts.subList(1,2) , 30, "Free");
        employees[7] = new Employee(7, "Meas Saly", skills.subList(2, 3), preferredShifts.subList(0,1) , 40, "Free");
        employees[8] = new Employee(8, "Amzz Menage", skills.subList(2, 3), preferredShifts.subList(1,2) , 30, "Free");
        employees[9] = new Employee(9, "Jonh Sina", skills.subList(3, 4), preferredShifts.subList(0,1) , 40, "Free");
        employees[10] = new Employee(10, "Thouen Theara", skills.subList(3, 4), preferredShifts.subList(0,1) , 30, "Free");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Employee Management System");
            System.out.println("2. Project Assignment System");
            System.out.println("3. Find Available Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayEmployeeManagementSystem(employees);
                    break;
                case 2:
                    projectAssignment(employees);
                    break;
                case 3:
                    displayAvailableEmployees(employees);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
}