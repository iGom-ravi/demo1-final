package com.example.demo1.demo1.values;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AccountOpenBalance {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int accBal;
	@Column
	private String userName;
	@Column
	private String accType;
	
	public AccountOpenBalance() {
		
	}
	public AccountOpenBalance(int id, int accBal, String userName, String accType) {
		super();
		this.id = id;
		this.accBal = accBal;
		this.userName = userName;
		this.accType = accType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccBal() {
		return accBal;
	}
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	@Override
	public String toString() {
		return "AccountOpenBalance [id=" + id + ", accBal=" + accBal + ", userName=" + userName + ", accType=" + accType
				+ "]";
	}

}
