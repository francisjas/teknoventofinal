package com.Technovento.tms.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderid;
	 private double total;
	 private int quantity;
	 private boolean status;
	 private String itemname;
	 private double remainingpayment;
	 private String picturelink;
	 @ManyToOne
	 @JoinColumn(name ="itemid")
	 InventoryEntity inventory;
	 
	 @ManyToOne
	 @JoinColumn(name ="customerid")
	 CustomerEntity customer;
	 
	 
	public OrderEntity() {}



	public OrderEntity(int orderid, double total, int quantity, boolean status, String itemname,
			double remainingpayment, InventoryEntity inventory, CustomerEntity customer,String picturelink) {
		super();
		this.orderid = orderid;
		this.total = total;
		this.quantity = quantity;
		this.status = status;
		this.itemname = itemname;
		this.picturelink = picturelink;
		this.remainingpayment = remainingpayment;
		this.inventory = inventory;
		this.customer = customer;
	}
    

	public String getPicturelink() {
		return picturelink;
	}


	public void setPicturelink(String picturelink) {
		this.picturelink = picturelink;
	}



	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getRemainingpayment() {
		return remainingpayment;
	}

	public void setRemainingpayment(double remainingpayment) {
		this.remainingpayment = remainingpayment;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}


	
}
