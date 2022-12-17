package com.example.repository;

import com.example.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e from Employee e where e.lastName =:name ")
    List<Employee> findByLastName(@Param("name") String lastName);

//    List<Employee> findByLastName_1(String lastName);

    Employee findByFirstNameLike(String firstName);

    Employee findByEmployeeIdIn(List<Integer> list );


    Employee findByEmail(String email);

    List<Employee> findByLastNameOrderByEmployeeIdDesc(String name);

    List<Employee> findByEmployeeIdBetween(String first, String last);

}
