package com.ansari.employee_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponseDto {
	
	EmployeeDto employeeDto;
	DepartmentDto departmentDto;

	
}
