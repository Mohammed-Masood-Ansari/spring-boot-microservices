package com.ansari.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.department_service.entity.Department;
import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
	Department findByDepartmentCode(String departmentCode);

}
