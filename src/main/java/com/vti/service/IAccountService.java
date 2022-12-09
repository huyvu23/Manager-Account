package com.vti.service;

import java.util.List;


import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdate;

public interface IAccountService {
	public List<Account> getListAccount(String search);

	public void deleteAccountById(short id);
	
	public void createAccount(AccountFormForCreating formForCreating);
	
	public void updateAccount(short id , AccountFormForUpdate formForUpdate);
}
