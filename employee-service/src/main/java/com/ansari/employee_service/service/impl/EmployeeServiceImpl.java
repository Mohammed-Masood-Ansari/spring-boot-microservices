package com.ansari.employee_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ansari.employee_service.dto.ApiResponseDto;
import com.ansari.employee_service.dto.DepartmentDto;
import com.ansari.employee_service.dto.EmployeeDto;
import com.ansari.employee_service.entity.Employee;
import com.ansari.employee_service.repository.EmployeeRepository;
import com.ansari.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
	private ModelMapper mapper;
	
	
//	private RestTemplate restTemplate;
	
	
//	private WebClient webClient;
	
	private ApiClient apiClient;

	@Override
	public EmployeeDto saveEmployeeService(Employee employee) {
		
		Employee employee2 = employeeRepository.save(employee);
		
	    return mapper.map(employee2, EmployeeDto.class);
	}

	@Override
	public ApiResponseDto getEmployeeByIdService(Long empId) {
		
		Employee employee = employeeRepository.findById(empId).get();
		
		//rest api call statement with rest template
		
//		ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8181/api/departmentService/"+employee.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto departmentDto  = responseEntity.getBody();
		
		
		//rest api call statement with the help of webclient
//		DepartmentDto departmentDto=webClient.get().uri("http://localhost:8181/api/departmentService/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
		
		//used to fetch rest api by using open feign cloud 
		DepartmentDto departmentDto = apiClient.getDepartmentByCodeController(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = mapper.map(employee,EmployeeDto.class);
		
		return ApiResponseDto.builder()
		.employeeDto(employeeDto)
		.departmentDto(departmentDto)
		.build();
	}

}
