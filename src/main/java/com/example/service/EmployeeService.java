package com.example.service;

import com.example.controller.EmployeeNotFound;
import com.example.dto.Employee;
import com.example.repository.EmployeePaginationRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees;

    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

    Pageable secondPageWithFiveElements = PageRequest.of(1, 5);

    Pageable sortedByFirstName = PageRequest.of(0, 7, Sort.by("firstName"));

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeePaginationRepository employeePaginationRepository;

    public EmployeeService() {
        employees = new ArrayList<>();
        employees.add(new Employee("1001", "Mukesh", "Chandra", "mukesh.chandra@gmail.com", "1234567890"));
        employees.add(new Employee("1002", "Suresh", "Chandra", "suresh.chandra@gmail.com", "1111111111"));
        employees.add(new Employee("1003", "Kavya", "Joshi", "kavya.joshi@gmail.com", "222222222"));
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public List<Employee> getPaginatedEmployees(){
       return employeePaginationRepository.findAllByLastName("Chandra", sortedByFirstName);
    }

    public Employee addEmployee(Employee employee) {

        return repository.save(employee);
    }

    public Employee getEmployeeById(String employeeId) throws EmployeeNotFound {
        Employee employee = repository.findById(employeeId).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFound("Employee with Id  " + employeeId + " not found ::");
        }
        return employee;
    }


    public Employee updateEmployee(String employeeId, Employee employee) throws EmployeeNotFound {
        Employee employeeFromDB = getEmployeeById(employeeId);
        if (employeeFromDB != null) {
            employeeFromDB.setFirstName(employee.getFirstName());
            employeeFromDB.setLastName(employee.getLastName());
            employee.setEmail(employee.getEmail());
            employee.setPhoneNo(employee.getPhoneNo());
            repository.save(employeeFromDB);
            return employee;
        }


        return null;
    }

    public void deleteEmployee(Employee employee) {
        repository.delete(employee);

    }

    public Employee findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Employee> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public List<Employee> findByLastNameAndOrderBy(String lastName) {
        return repository.findByLastNameOrderByEmployeeIdDesc(lastName);
    }

    public List<Employee> findByEmployeeIdWhereIdBetween(String first, String last) {
        return repository.findByEmployeeIdBetween(first, last);
    }
}
