package com.Technovento.tms.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customerlogin")
public class LoginCustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int loginid;
	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name ="customerid")
	CustomerEntity customer;
	
	public LoginCustomerEntity(){}
	
	public LoginCustomerEntity(int loginid, String username, String password, CustomerEntity customer) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
		this.customer = customer;
	}
	
	
	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
