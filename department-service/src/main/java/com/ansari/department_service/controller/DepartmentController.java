package com.ansari.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.department_service.dto.DepartmentDto;
import com.ansari.department_service.entity.Department;
import com.ansari.department_service.service.DepartmentService;

@RestController
@RequestMapping(value = "/departmentservice")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartmentController(@RequestBody Department department) {
		
		DepartmentDto departmentDto=departmentService.saveDepartmentService(department);
		
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "{department-code}")
	public  ResponseEntity<DepartmentDto> getDepartmentByCodeController(@PathVariable(name = "department-code") String departmentCode) {
		
		DepartmentDto departmentDto=departmentService.getDepartmentByCodeService(departmentCode);
		
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}

}
