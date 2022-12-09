package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

// Class này dành cho chức năng search
public class AccountSpecification implements Specification<Account> {

//	Field là đối tượng cần tìm 
	private String field;

// Toán tử so sánh 
	private String operator;

//	Giá trị cần để so sánh 
	private Object value;

	public AccountSpecification(String field, String operator, Object value) {
		super();
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

//	Hàm này định nghĩa ra điều kiện tìm kiếm 
	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (operator.equalsIgnoreCase("LIKE")) {
			if (field.equalsIgnoreCase("department")) {
				return criteriaBuilder.like(root.get("department").get("name"), "%" + value.toString() + "%");
			} else {
				return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
			}
		}
		return null;
	}

}
