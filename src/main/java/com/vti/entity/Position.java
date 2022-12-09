package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Position", catalog = "LearnJDBC")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PositionID")
	private short id;

	@Enumerated(EnumType.STRING)
	@Column(name = "PositionName", nullable = false)
	private PositionName name;

	@OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
	private List<Account> listAccounts;

	public enum PositionName {
		Dev, Test, ScrumMaster, PM
	}

	public Position() {
		super();
	}

	public Position(short id, PositionName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

}
