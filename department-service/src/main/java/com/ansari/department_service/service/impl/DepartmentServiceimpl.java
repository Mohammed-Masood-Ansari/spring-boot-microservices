package com.ansari.department_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ansari.department_service.dto.DepartmentDto;
import com.ansari.department_service.entity.Department;
import com.ansari.department_service.repository.DepartmentRepository;
import com.ansari.department_service.service.DepartmentService;

@Service
public class DepartmentServiceimpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartmentService(Department department) {
		
		Department department2=departmentRepository.save(department);
		
		return new DepartmentDto(department2.getId(), department2.getName(), department2.getDescription(), department2.getDepartmentCode());
	}

	@Override
	public DepartmentDto getDepartmentByCodeService(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		return new DepartmentDto(department.getId(), department.getName(), department.getDescription(), department.getDepartmentCode());
	}
}
