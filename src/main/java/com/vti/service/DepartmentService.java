package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IDepartmentRepository;


// Báo hiệu đây là tầng Service
@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(short id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	@Override
	public void deleteById(short id) {
		 departmentRepository.deleteById(id);
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		Department department = new Department();
		String newName = form.getName();
		department.setName(newName);
		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(short id, DepartmentFormForUpdating formForUpdating) {
		Department department = departmentRepository.findById(id).get();
		department.setName(formForUpdating.getName());
		departmentRepository.save(department);
	}
	


}
