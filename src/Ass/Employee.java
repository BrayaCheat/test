package Ass;
import java.util.*;
import java.util.stream.Collectors;
public class Employee {
    private int id;
    private String name;
    private List<String> skills;
    private List<String> preferredShifts;
    private int shiftBankHours;
    private String status;
    private String startTime;
    private String endTime;
    private String role;
    private String deadline;

    public Employee(int id, String name, List<String> skills, List<String> preferredShifts,
                    int shiftBankHours, String status) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.preferredShifts = preferredShifts;
        this.shiftBankHours = shiftBankHours;
        this.status = status;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
    public List<String> getPreferredShifts() {
        return preferredShifts;
    }
    public void setPreferredShifts(List<String> preferredShifts) {
        this.preferredShifts = preferredShifts;
    }
    public int getShiftBankHours() {
        return shiftBankHours;
    }
    public void setShiftBankHours(int shiftBankHours) {
        this.shiftBankHours = shiftBankHours;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    static void displayEmployeeManagementSystem(Employee[] employees) {
        System.out.println("Employee Management System:");
        System.out.print("===========================");

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Create Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. View all Employee");
        System.out.println("4. Search Employee");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                CreateEmp(employees);
                break;
            case 2:
                editEmployee(employees);
                break;
            case 3:
                ViewAllEmp(employees);
                break;
            case 4:
                viewEmployee(employees);
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    private static void editEmployee(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the employee to edit: ");
        int employeeId = scanner.nextInt();

        Employee employeeToEdit = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == employeeId) {
                employeeToEdit = employee;
                break;
            }
        }

        if (employeeToEdit != null) {
            System.out.print("Enter the new name: ");
            scanner.nextLine();
            String newName = scanner.nextLine();
            employeeToEdit.setName(newName);

            System.out.println("Skills:");
            System.out.println("1. Front-end Developer");
            System.out.println("2. Back-end Developer");
            System.out.println("3. Network Engineering");
            System.out.println("4. Network Support");
            System.out.print("Enter the numbers corresponding to the skills (comma-separated): ");
            String skillChoices = scanner.nextLine();
            String[] skillChoiceArray = skillChoices.split(",");
            List<String> newSkills = new ArrayList<>();
            for (String choice : skillChoiceArray) {
                int skillIndex = Integer.parseInt(choice.trim());
                switch (skillIndex) {
                    case 1:
                        newSkills.add("Front-end Developer");
                        break;
                    case 2:
                        newSkills.add("Back-end Developer");
                        break;
                    case 3:
                        newSkills.add("Network Engineering");
                        break;
                    case 4:
                        newSkills.add("Network Support");
                        break;
                    default:
                        System.out.println("Invalid skill choice: " + skillIndex);
                        break;
                }
            }
            employeeToEdit.setSkills(newSkills);

            System.out.print("Enter the new hours: ");
            int newShiftBankHours = scanner.nextInt();
            employeeToEdit.setShiftBankHours(newShiftBankHours);

            System.out.print("Enter the new status: ");
            scanner.nextLine();
            String newStatus = scanner.nextLine();
            employeeToEdit.setStatus(newStatus);

            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }
    private static void ViewAllEmp(Employee[] employees) {
        List<Employee> nonNullEmployees = Arrays.stream(employees)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        nonNullEmployees.sort(Comparator.comparingInt(Employee::getId));
        System.out.printf("%-5s%-25s%-25s%-15s%-10s%-10s%-15s%n", "ID", "Name", "Skills", "Shifts", "Hours", "Status","Deadline");
        for (Employee employee : nonNullEmployees) {
            System.out.printf("%-5s%-25s%-25s%-15s%-10s%-10s%-15s%n",
                    employee.getId(),
                    employee.getName(),
                    String.join(", ", employee.getSkills()),
                    employee.getPreferredShifts(),
                    employee.getShiftBankHours(),
                    employee.getStatus(),
                    employee.getDeadline());
            System.out.println("-------------------------------------------------------------------------------------------------------");
        }
    }
    private static void viewEmployee(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the employee to view: ");
        int employeeId = scanner.nextInt();

        Employee employeeToView = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == employeeId) {
                employeeToView = employee;
                break;
            }
        }
        if (employeeToView != null) {
            System.out.println("Employee Details:");
            System.out.println("================");
            System.out.println("ID: " + employeeToView.getId());
            System.out.println("Name: " + employeeToView.getName());
            System.out.println("Skills: " + String.join(", ", employeeToView.getSkills()));
            System.out.println("Preferred Shifts: " + employeeToView.getPreferredShifts().toString());
            System.out.println("Shift Bank Hours: " + employeeToView.getShiftBankHours());
            System.out.println("Status: " + employeeToView.getStatus());
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }
    static void displayAvailableEmployees(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Finding Available Employees:");
        System.out.println("============================");
        System.out.println("1. Find by Shift");
        System.out.println("2. Find by Skill");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                findByShift(employees);
                break;
            case 2:
                findBySkill(employees);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    private static void findByShift(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Shifts:");
        System.out.println("1. Morning");
        System.out.println("2. Afternoon");
        System.out.println("3. Night");
        System.out.print("Enter the shift number: ");
        int shiftNumber = scanner.nextInt();

        String shift;
        switch (shiftNumber) {
            case 1:
                shift = "Morning";
                break;
            case 2:
                shift = "Afternoon";
                break;
            case 3:
                shift = "Night";
                break;
            default:
                System.out.println("Invalid shift number. Please try again.");
                return;
        }

        List<Employee> nonNullEmployees = Arrays.stream(employees)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int a=0;
        nonNullEmployees.sort(Comparator.comparingInt(Employee::getId));

        System.out.printf("%-5s%-25s%-25s%-15s%-10s%-10s%n", "ID", "Name", "Skills", "Shifts", "Hours", "Status");
        for (Employee employee : nonNullEmployees) {
            if (employee != null && employee.getPreferredShifts().contains(shift) && Objects.equals(employee.status, "Free")) {
                System.out.printf("%-5s%-25s%-25s%-15s%-10s%-10s%n",
                        employee.getId(),
                        employee.getName(),
                        String.join(", ", employee.getSkills()),
                        employee.getPreferredShifts(),
                        employee.getShiftBankHours(),
                        employee.getStatus());
                System.out.println("--------------------------------------------------------------------------------------------------------------------");

                a = 1;
            }
        }
        if (a == 0) System.out.println("No Available Employee in this Shift");
    }
    private static void findBySkill(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Skills:");
        System.out.println("1. Front-end Developer");
        System.out.println("2. Back-end Developer");
        System.out.println("3. Network Engineering");
        System.out.println("4. Network Support");
        System.out.print("Enter the skill number: ");
        int skillNumber = scanner.nextInt();

        String skill;
        switch (skillNumber) {
            case 1:
                skill = "Front-end Developer";
                break;
            case 2:
                skill = "Back-end Developer";
                break;
            case 3:
                skill = "Network Engineering";
                break;
            case 4:
                skill = "Network Support";
                break;
            default:
                System.out.println("Invalid skill number. Please try again.");
                return;
        }

        List<Employee> nonNullEmployees = Arrays.stream(employees)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int a = 0;
        nonNullEmployees.sort(Comparator.comparingInt(Employee::getId));

        System.out.printf("%-5s%-20s%-25s%-20s%-20s%-20s%n", "ID", "Name", "Skills", "Shifts", "Hours", "Status");
        for (Employee employee : nonNullEmployees) {
            if (employee != null && Objects.equals(employee.getStatus(), "Free") && employee.getSkills().contains(skill)) {
                System.out.printf("%-5d%-20s%-25s%-20s%-20d%-20s%n",
                        employee.getId(),
                        employee.getName(),
                        String.join(", ", employee.getSkills()),
                        employee.getPreferredShifts(),
                        employee.getShiftBankHours(),
                        employee.getStatus());
                System.out.println("--------------------------------------------------------------------------------------------------------------------");

                a = 1;
            }
        }
        if (a == 0) System.out.println("No Available Employee with this Skill");
    }
    private static void CreateEmp(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the employee: ");
        int id = scanner.nextInt();
        System.out.print("Enter the name of the employee: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Skills:");
        System.out.println("1. Front-end Developer");
        System.out.println("2. Back-end Developer");
        System.out.println("3. Network Engineering");
        System.out.println("4. Network Support");
        System.out.print("Enter the numbers corresponding to the skills (comma-separated): ");
        String skillChoices = scanner.nextLine();
        String[] skillChoiceArray = skillChoices.split(",");
        List<String> skills = new ArrayList<>();
        for (String choice : skillChoiceArray) {
            int skillIndex = Integer.parseInt(choice.trim());
            switch (skillIndex) {
                case 1:
                    skills.add("Front-end Developer");
                    break;
                case 2:
                    skills.add("Back-end Developer");
                    break;
                case 3:
                    skills.add("Network Engineering");
                    break;
                case 4:
                    skills.add("Network Support");
                    break;
                default:
                    System.out.println("Invalid skill choice: " + skillIndex);
                    break;
            }
        }
        System.out.println("Preferred Shifts:");
        System.out.println("1. Morning");
        System.out.println("2. Afternoon");
        System.out.println("3. Night");
        System.out.print("Enter the numbers corresponding to the preferred shifts (comma-separated): ");
        String shiftChoices = scanner.nextLine();
        String[] shiftChoiceArray = shiftChoices.split(",");
        List<String> preferredShifts = new ArrayList<>();
        for (String choice : shiftChoiceArray) {
            int shiftIndex = Integer.parseInt(choice.trim());
            switch (shiftIndex) {
                case 1:
                    preferredShifts.add("Morning");
                    break;
                case 2:
                    preferredShifts.add("Afternoon");
                    break;
                case 3:
                    preferredShifts.add("Night");
                    break;
                default:
                    System.out.println("Invalid shift choice: " + shiftIndex);
                    break;
            }
        }

        System.out.print("Enter the hours: ");
        int shiftBankHours = scanner.nextInt();
        System.out.print("Enter the Status: ");
        scanner.nextLine();
        String Status = scanner.nextLine();
        Employee newEmployee = new Employee(id, name, skills, preferredShifts, shiftBankHours,Status);
        // Find an empty slot in the employees array and add the new employee
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                System.out.println("New employee created successfully.");
                return;
            }
        }
        System.out.println("Employee database is full. Cannot add new employee.");
    }
    public static void projectAssignment(Employee[] employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the project name: ");
        String projectName = scanner.nextLine();

        Map<String, Integer> skillMap = new HashMap<>();
        System.out.println("Skills:");
        System.out.println("1. Front-end Developer");
        System.out.println("2. Back-end Developer");
        System.out.println("3. Network Engineering");
        System.out.println("4. Network Support");
        // Allow the user to input multiple skills for the project
        while (true) {
            System.out.print("Enter skill number (0 to finish): ");
            int skillChoice = scanner.nextInt();
            if (skillChoice == 0) {
                break;
            }
            System.out.print("Enter the number of employees needed for this skill: ");
            int numberOfEmployees = scanner.nextInt();
            String requiredSkill;
            switch (skillChoice) {
                case 1:
                    requiredSkill = "Front-end Developer";
                    break;
                case 2:
                    requiredSkill = "Back-end Developer";
                    break;
                case 3:
                    requiredSkill = "Network Engineering";
                    break;
                case 4:
                    requiredSkill = "Network Support";
                    break;
                default:
                    System.out.println("Invalid skill choice. Project assignment aborted.");
                    return;
            }
            skillMap.put(requiredSkill, numberOfEmployees);
        }

        System.out.print("Enter the project deadline (YYYY-MM-DD): ");
        String deadline = scanner.next();

        List<Employee> selectedEmployees = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : skillMap.entrySet()) {
            String skill = entry.getKey();
            int numberOfEmployees = entry.getValue();

            List<Employee> availableEmployees = Arrays.stream(employees)
                    .filter(employee -> employee != null && Objects.equals(employee.getStatus(), "Free") &&
                            employee.getSkills().contains(skill))
                    .collect(Collectors.toList());
            if (availableEmployees.size() < numberOfEmployees) {
                System.out.println("Insufficient available employees with the required skill for " + skill);
                return;
            }
            System.out.println("Available Employees for " + skill + " Assignment:");
            for (int i = 0; i < availableEmployees.size(); i++) {
                System.out.println((i + 1) + ". " + availableEmployees.get(i).getName());
            }
            System.out.print("Choose " + numberOfEmployees + " employees for " + skill + " (comma-separated): ");
            String employeeChoices = scanner.next();
            String[] employeeChoiceArray = employeeChoices.split(",");
            for (String choice : employeeChoiceArray) {
                int employeeIndex = Integer.parseInt(choice.trim()) - 1;
                if (employeeIndex >= 0 && employeeIndex < availableEmployees.size()) {
                    Employee selectedEmployee = availableEmployees.get(employeeIndex);
                    selectedEmployees.add(selectedEmployee);
                    selectedEmployee.setStatus(projectName);
                    selectedEmployee.setDeadline(deadline);
                } else {
                    System.out.println("Invalid employee choice: " + (employeeIndex + 1));
                }
            }
        }

        System.out.println("Project assignment completed successfully.");
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public String getDeadline() {
        return deadline;
    }
}