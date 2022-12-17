package com.example.controller;

import com.example.dto.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Employee> getAllEmployees() {

        return service.getEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId) throws EmployeeNotFound {
        return service.getEmployeeById(employeeId);
    }

    @GetMapping("/email/{email}")
    public Employee findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/lastName/{lastName}")
    public List<Employee> findByLastName(@PathVariable String lastName) {
        return service.findByLastName(lastName);
    }

    @GetMapping("/lastNameDesc/{lastName}")
    public List<Employee> findByLastNameAndOrderBy(@PathVariable String lastName) {
        return service.findByLastNameAndOrderBy(lastName);
    }

    @GetMapping("/between/{first}/{last}")
    public List<Employee> findInRange(@PathVariable  String first, @PathVariable String last) {
        return service.findByEmployeeIdWhereIdBetween(first, last);
    }

    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) throws EmployeeNotFound {
        return service.updateEmployee(employeeId, employee);
    }

    @GetMapping("Paginated/all")
    public List<Employee> getEmployees(){
        return service.getPaginatedEmployees();
    }

    @PutMapping("/delete")
    public String deleteEmployee(@RequestBody Employee employee) {
        service.deleteEmployee(employee);
        return "successfully deleted employee ";
    }
}
