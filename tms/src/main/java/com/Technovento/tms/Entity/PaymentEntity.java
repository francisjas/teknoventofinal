package com.Technovento.tms.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_payment")
public class PaymentEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;
	private String paymentmethod;
	private int cash; 
	
	
	@ManyToOne
	@JoinColumn(name ="orderid")
	OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name ="customerid")
	CustomerEntity customer;
	
	
	public PaymentEntity() {}
	

	public PaymentEntity(int paymentid, String paymentmethod, int cash, OrderEntity order, CustomerEntity customer) {
		super();
		this.paymentid = paymentid;
		this.paymentmethod = paymentmethod;
		this.cash = cash;
		this.order = order;
		this.customer = customer;
	}



	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	
	
}
