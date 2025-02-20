package com.ansari.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.employee_service.dto.ApiResponseDto;
import com.ansari.employee_service.dto.EmployeeDto;
import com.ansari.employee_service.entity.Employee;
import com.ansari.employee_service.service.EmployeeService;

@RestController
@RequestMapping(value = "/employeeservice")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployeeController(@RequestBody Employee employee) {
		
		EmployeeDto dto = employeeService.saveEmployeeService(employee);
		
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.CREATED);
	}


	@GetMapping(value = "{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeByIdController(@PathVariable(name = "id") Long empId) {
		
		ApiResponseDto dto = employeeService.getEmployeeByIdService(empId);
		
		return new ResponseEntity<ApiResponseDto>(dto, HttpStatus.OK);
	}
}
