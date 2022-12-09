package com.vti.service;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdate;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.specification.AccountSpecification;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IPositionRepository positionRepository;

	@Override
	public List<Account> getListAccount(String search) {
//		Đoạn này dành cho chức năng tìm 
		Specification<Account> where = null;
		if (search != null) {
			AccountSpecification fullName = new AccountSpecification("fullName", "LIKE", search);
			AccountSpecification email = new AccountSpecification("email", "LIKE", search);
			where = Specification.where(fullName).or(email);
		}
		return accountRepository.findAll(where);
	}

	@Override
	public void deleteAccountById(short id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void createAccount(AccountFormForCreating formForCreating) {
		Account account = new Account();
		short idDepartment = formForCreating.getDepartmentId();
		short idPosition = formForCreating.getPositionId();
		@SuppressWarnings("deprecation")
		Department department = departmentRepository.getById(idDepartment);
		@SuppressWarnings("deprecation")
		Position position = positionRepository.getById(idPosition);
		account.setEmail(formForCreating.getEmail());
		account.setFullName(formForCreating.getFullName());
		account.setUserName(formForCreating.getUserName());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);

	}

	@Override
	public void updateAccount(short id, AccountFormForUpdate formForUpdate) {
		Account account = accountRepository.findById(id).get();
		short idDepartment = formForUpdate.getDepartmentId();
		short idPosition = formForUpdate.getPositionId();
		Department department = departmentRepository.findById(idDepartment).get();
		Position position = positionRepository.findById(idPosition).get();
		account.setFullName(formForUpdate.getFullName());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);

	}

}
