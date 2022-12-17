package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @NotEmpty(message = "employeeId can not be null")
    @Size(min = 5)
    @Column(name = "employee_Id")
    private String employeeId;
    @NotEmpty(message = "firstName can not be null")
    @Column(name = "first_Name")
    private String firstName;
    @NotEmpty(message = "lastName can not be null")
    @Column(name = "last_Name")
    private String lastName;
    @NotEmpty(message = "email can not be null")
    @Email
    @Column(name = "email")
    private String email;
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^$|[0-9]{10})")
    @Column(name = "phone_No")
    private String phoneNo;
}
