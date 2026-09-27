package com.nashtech.employee;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {

        if (employee.getSalary() < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative"
            );
        }

        if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            throw new DuplicateEmployeeException(
                    "Employee with ID "
                            + employee.getEmployeeId()
                            + " already exists"
            );
        }

        employeeRepository.addEmployee(employee);
    }

    public void displayAllEmployees() {
        employeeRepository.getAllEmployees()
                .forEach(System.out::println);
    }

    public Employee findEmployeeById(int employeeId) {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + employeeId + " not found"
                        )
                );
    }

    public void displayEmployeesByDepartment(String department) {

        employeeRepository.getAllEmployees()
                .stream()
                .filter(employee ->
                        employee.getDepartment()
                                .equalsIgnoreCase(department))
                .forEach(System.out::println);
    }

    public void displayActiveEmployeesWithSalaryGreaterThan(
            double salary) {

        employeeRepository.getAllEmployees()
                .stream()
                .filter(Employee::isActive)
                .filter(employee ->
                        employee.getSalary() > salary)
                .forEach(System.out::println);
    }
}