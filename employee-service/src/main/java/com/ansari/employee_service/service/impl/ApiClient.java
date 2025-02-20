package com.ansari.employee_service.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ansari.employee_service.dto.DepartmentDto;

//below annotation will call openfeignclient dept 
//@FeignClient(url = "http://localhost:8181",value = "department-service")
//below annotation manage to call any instances of department service if one is off
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {
	
	
	@GetMapping(value = "/departmentservice/{department-code}")
	public DepartmentDto getDepartmentByCodeController(@PathVariable(name = "department-code") String departmentCode);

}
