package com.vti.dto;

public class AccountDto {
	private short id;
	private String email;
	private String username;
	private String fullname;
	private short department;
	private short position;

	public AccountDto() {
		super();
	}

	public AccountDto(short id, String email, String username, String fullname, short department, short position) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public short getDepartment() {
		return department;
	}

	public void setDepartment(short department) {
		this.department = department;
	}

	public short getPosition() {
		return position;
	}

	public void setPosition(short position) {
		this.position = position;
	}
}
