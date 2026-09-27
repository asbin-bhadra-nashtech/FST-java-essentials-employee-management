package com.nashtech.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> findById(int employeeId);

}