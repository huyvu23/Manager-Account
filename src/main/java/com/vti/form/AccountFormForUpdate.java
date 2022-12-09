package com.vti.form;

public class AccountFormForUpdate {
	private String fullName;
	private short departmentId;
	private short positionId;

	public AccountFormForUpdate() {
		super();
	}

	public AccountFormForUpdate(String fullName, short departmentId, short positionId) {
		super();
		this.fullName = fullName;
		this.departmentId = departmentId;
		this.positionId = positionId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	public short getPositionId() {
		return positionId;
	}

	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}

}
