package com.bhartIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhartIT.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    Employees findByEmployeeNameAndEmployeePassword(String employeeName, String employeePassword);
}
