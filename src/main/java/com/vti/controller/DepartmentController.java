package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping
	private ResponseEntity<?> getListDepartment() {
		List<Department> listDepartments = departmentService.getAllDepartments();
		List<DepartmentDto> listDepartmentDtos = new ArrayList<>();
		for (Department department : listDepartments) {
			DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName());
			listDepartmentDtos.add(departmentDto);
		}
		return new ResponseEntity<>(listDepartmentDtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<?> getDepartmentbyId(@PathVariable(name = "id") short id) {
		Department department = departmentService.getDepartmentById(id);
		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName());
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

	@GetMapping(value = "name/{nameSearch}")
	private ResponseEntity<?> getDepartmentbyName(@PathVariable(name = "nameSearch") String name) {
		Department department = departmentService.getDepartmentByName(name);
		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName());
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<?> deleteDepartmentById(@PathVariable(name = "id") short id) {
		departmentService.deleteById(id);
		return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
	}

//  Vì dữ liệu truyền thông qua Body nên sẽ sử dụng anotation @RequestBody
	@PostMapping(value = "/create")
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		departmentService.createDepartment(form);
		return new ResponseEntity<String>("Create sucess", HttpStatus.CREATED);
	}

	@PutMapping(value = "update/{id}")
	private ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFormForUpdating form) {
		departmentService.updateDepartment(id, form);
		return new ResponseEntity<String>("Update sucess", HttpStatus.CREATED);
	}
}
