package com.nashtech.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private final Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.getEmployeeId(), employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Optional<Employee> findById(int employeeId) {
        return Optional.ofNullable(employees.get(employeeId));
    }
}