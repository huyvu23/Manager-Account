package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`Account`", catalog = "LearnJDBC")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AccountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
	private String userName;

	@Column(name = "FullName", length = 50, nullable = false)
	private String fullName;

	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;

	public Account() {
		super();
	}

	public Account(short id, String email, String userName, String fullName, Department department, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
