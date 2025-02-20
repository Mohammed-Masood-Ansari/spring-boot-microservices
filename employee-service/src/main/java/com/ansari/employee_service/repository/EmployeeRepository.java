package com.ansari.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
