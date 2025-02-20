package com.ansari.department_service.service;

import com.ansari.department_service.dto.DepartmentDto;
import com.ansari.department_service.entity.Department;

public interface DepartmentService {

	DepartmentDto saveDepartmentService(Department department);
	
	DepartmentDto getDepartmentByCodeService(String departmentCode);
}
