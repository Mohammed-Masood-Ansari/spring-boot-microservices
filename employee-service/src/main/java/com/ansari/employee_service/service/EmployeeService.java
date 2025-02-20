package com.ansari.employee_service.service;

import com.ansari.employee_service.dto.ApiResponseDto;
import com.ansari.employee_service.dto.EmployeeDto;
import com.ansari.employee_service.entity.Employee;

public interface EmployeeService {
	
	EmployeeDto saveEmployeeService(Employee employee);
	
	ApiResponseDto getEmployeeByIdService(Long empId);
	
}
