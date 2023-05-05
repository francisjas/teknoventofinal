package com.Technovento.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Technovento.tms.Entity.OrderEntity;
import com.Technovento.tms.Repository.OrderRepository;


@Service
public class OrderService {
	@Autowired
	OrderRepository srepo;
	@Autowired
	CustomerService cserv;

	
	//C - Create or insert an order record
	public OrderEntity insertOrderItem(OrderEntity order) {
		order.setTotal(order.getInventory().getItemprice() *order.getQuantity());
		order.setItemname(order.getInventory().getItemname());
		order.setRemainingpayment(order.getTotal());
		order.setPicturelink(order.getPicturelink());
		return srepo.save(order);
	}
	
	//R - Read all records from tbl_order
	public List<OrderEntity> getAllOrder(){
        return srepo.findAll();
    }
	
	//R - Read or search student record by order item name
	public List<OrderEntity>  findByOrderid(int orderid) {
		if (srepo.findByOrderid(orderid) != null)
			return srepo.findByOrderid(orderid);
		else
			return null;
	}
	//U - Update a order record
	public OrderEntity putOrder(int orderid, OrderEntity newOrderDetails) throws Exception{
		
		OrderEntity order = new OrderEntity();
		
		try {
			 //Search the ID number of an order
			order = srepo.findById(orderid).get();
			  
            //update the record
			order.setQuantity(newOrderDetails.getQuantity());
			order.setTotal(newOrderDetails.getInventory().getItemprice()*order.getQuantity());
			order.setStatus(newOrderDetails.isStatus());
			order.setRemainingpayment(newOrderDetails.getRemainingpayment());
			order.setItemname(newOrderDetails.getInventory().getItemname());
			order.setPicturelink(newOrderDetails.getPicturelink());
			
			 //Save the information and return the value
			return srepo.save(order);
		}catch(NoSuchElementException nex) {
			 //throws an error if the id does not exist
			throw new Exception("Order ID Number "+ orderid + "does not exist");
		}
	}
		
		//D- Delete order record
		public String deleteOrder(int orderid) {
			String msg;
			if(srepo.findById(orderid) != null) {
				srepo.deleteById(orderid);//find the order id number of the customer to be deleted
				msg = "Order ID Number " + orderid + " is successfully deleted!";
			}
			else 
				msg = "Order ID Number" + orderid + "is NOT found!";
			return msg;
		}
		
		public OrderEntity updateRemaining(int orderid, double payment) throws Exception{
			OrderEntity order = new OrderEntity();
			try {
				 //Search the ID number of an order
				order = srepo.findById(orderid).get();
	            //update the payment
				order.setRemainingpayment(order.getRemainingpayment() - payment);
				if(order.getRemainingpayment() == 0) {
					order.setStatus(true);
				}
				 //Save the information and return the value
				return srepo.save(order);
			}catch(NoSuchElementException nex) {
				 //throws an error if the id does not exist
				throw new Exception("Order ID Number "+ orderid + "does not exist");
			}
		}
		
		public OrderEntity updatePayment(int orderid, double payment, double newPayment) throws Exception{
			OrderEntity order = new OrderEntity();
			try {
				 //Search the ID number of an order
				order = srepo.findById(orderid).get();
	            //update the payment
				if(payment > newPayment){
				  order.setRemainingpayment(order.getRemainingpayment() + (payment - newPayment));
					if(order.getRemainingpayment() <= 0) {
						order.setStatus(true);
					}
				}
				else if (payment < newPayment){
					order.setRemainingpayment(order.getRemainingpayment() - (newPayment + payment));
					if(order.getRemainingpayment() > 0) {
						order.setStatus(false);
					}
				}
				
				
				 //Save the information and return the value
				return srepo.save(order);
			}catch(NoSuchElementException nex) {
				 //throws an error if the id does not exist
				throw new Exception("Order ID Number "+ orderid + "does not exist");
			}
		}
	
		
		
		
}
