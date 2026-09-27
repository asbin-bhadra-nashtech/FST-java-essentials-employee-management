package com.nashtech.employee;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(int employeeId,
                    String name,
                    String department,
                    double salary,
                    boolean active) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }

}