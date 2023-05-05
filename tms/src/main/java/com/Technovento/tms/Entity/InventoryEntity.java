package com.Technovento.tms.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_inventory")
public class InventoryEntity{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	private String itemname;
	private int quantity;
	private double itemprice;
	private String itemdescription;
	private String picturelink;
	
	 @ManyToOne
	 @JoinColumn(name ="managerid")
	 ManagerEntity manager;
	

	public InventoryEntity(){}


	public InventoryEntity(int itemid, String itemname, int quantity, double itemprice, String itemdescription,String picturelink,
			ManagerEntity manager) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.quantity = quantity;
		this.itemprice = itemprice;
		this.itemdescription = itemdescription;
		this.picturelink = picturelink;
		this.manager = manager;
	}


	public String getPicturelink() {
		return picturelink;
	}


	public void setPicturelink(String picture) {
		this.picturelink = picture;
	}


	public ManagerEntity getManager() {
		return manager;
	}


	public void setManager(ManagerEntity manager) {
		this.manager = manager;
	}


	public int getItemid() {
		return itemid;
	}


	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemdescription() {
		return itemdescription;
	}
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	public double getItemprice() {
		return itemprice;
	}
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}
	
	
	
	
	
}
