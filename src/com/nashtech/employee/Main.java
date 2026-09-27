package com.nashtech.employee;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeRepository repository =
                new InMemoryEmployeeRepository();

        EmployeeService service =
                new EmployeeService(repository);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            try {

                int choice = Integer.parseInt(input);

                switch (choice) {

                    case 1:
                        addEmployee(scanner, service);
                        break;

                    case 2:
                        displayAllEmployees(service);
                        break;

                    case 3:
                        searchEmployee(scanner, service);
                        break;

                    case 4:
                        displayByDepartment(scanner, service);
                        break;

                    case 5:
                        displayBySalary(scanner, service);
                        break;

                    case 6:
                        running = false;
                        System.out.println("Exiting application...");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please select 1-6."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       Employee Management System");
        System.out.println("========================================");
        System.out.println("1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Display Employees by Department");
        System.out.println("5. Display Active Employees by Salary");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    private static void addEmployee(
            Scanner scanner,
            EmployeeService service) {

        try {

            System.out.print("Enter Employee ID: ");
            int employeeId = Integer.parseInt(
                    scanner.nextLine()
            );

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            if (name.isBlank()) {
                throw new IllegalArgumentException(
                        "Employee name cannot be empty"
                );
            }

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(
                    scanner.nextLine()
            );

            System.out.print(
                    "Is Employee Active? (true/false): "
            );

            boolean active = Boolean.parseBoolean(
                    scanner.nextLine()
            );

            Employee employee = new Employee(
                    employeeId,
                    name,
                    department,
                    salary,
                    active
            );

            service.addEmployee(employee);

            System.out.println(
                    "Employee added successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid input. Employee ID and salary " +
                            "must be valid numbers."
            );

        } catch (DuplicateEmployeeException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    private static void displayAllEmployees(
            EmployeeService service) {

        System.out.println("\n=== All Employees ===");

        service.displayAllEmployees();
    }

    private static void searchEmployee(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Employee ID: ");

        int employeeId = Integer.parseInt(scanner.nextLine());

        try {

            Employee employee =
                    service.findEmployeeById(employeeId);

            System.out.println("\nEmployee found:");
            System.out.println(employee);

        } catch (EmployeeNotFoundException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    private static void displayByDepartment(
            Scanner scanner,
            EmployeeService service) {

        System.out.print("Enter Department: ");

        String department = scanner.nextLine();

        System.out.println(
                "\n=== Employees in " + department + " ==="
        );

        service.displayEmployeesByDepartment(department);
    }

    private static void displayBySalary(
            Scanner scanner,
            EmployeeService service) {

        System.out.print(
                "Enter minimum salary: "
        );

        double salary = Double.parseDouble(
                scanner.nextLine()
        );

        System.out.println(
                "\n=== Active Employees With Salary > "
                        + salary
                        + " ==="
        );

        service.displayActiveEmployeesWithSalaryGreaterThan(
                salary
        );
    }
}