package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdate;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@GetMapping
	private ResponseEntity<?> getListAccounts(@RequestParam(required = false) String search) {
		List<Account> listAccounts = accountService.getListAccount(search);
		List<AccountDto> listAccountDtos = new ArrayList<>();
		for (Account account : listAccounts) {
			AccountDto accountDto = new AccountDto();
			accountDto.setId(account.getId());
			accountDto.setEmail(account.getEmail());
			accountDto.setUsername(account.getUserName());
			accountDto.setFullname(account.getFullName());
			accountDto.setDepartment(account.getDepartment().getId());
			accountDto.setPosition(account.getPosition().getId());
			listAccountDtos.add(accountDto);
		}
		return new ResponseEntity<>(listAccountDtos, HttpStatus.OK);

	}

	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<?> deleteAccountById(@PathVariable(name = "id") short id) {
		accountService.deleteAccountById(id);
		return new ResponseEntity<String>("Delete Account Success", HttpStatus.OK);

	}

	@PostMapping(value = "/create")
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
		accountService.createAccount(form);
		return new ResponseEntity<String>("Create sucess", HttpStatus.CREATED);

	}

	@PutMapping(value = "update/{id}")
	private ResponseEntity<?> updateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdate form) {
		accountService.updateAccount(id, form);
		return new ResponseEntity<String>("Update sucess", HttpStatus.OK);

	}
}
