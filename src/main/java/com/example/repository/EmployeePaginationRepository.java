package com.example.repository;

import com.example.dto.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeePaginationRepository extends PagingAndSortingRepository<Employee, String> {

    List<Employee> findAllByLastName(String lastName, Pageable pageable);
}
