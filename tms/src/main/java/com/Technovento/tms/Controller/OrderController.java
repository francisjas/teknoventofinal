package com.Technovento.tms.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technovento.tms.Entity.CustomerEntity;
import com.Technovento.tms.Entity.OrderEntity;
import com.Technovento.tms.Service.InventoryService;
import com.Technovento.tms.Service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	  @Autowired
	    OrderService orderService;
	  @Autowired
	  	InventoryService iserv;
	  
	  
	    //Create or insert an order record
	  	@CrossOrigin
	    @PostMapping("/postOrder")
	    public String insertOrderItem(@RequestBody OrderEntity order) {
	    	String temp = "Failed to buy Item";
	    	if(order.getInventory().getQuantity()> order.getQuantity()) {
	    	try {
				iserv.updateQuantity(order.getInventory().getItemid(), order.getQuantity());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	orderService.insertOrderItem(order);
	    		temp = "Item bought successfully";
	        }
	    	return temp;
	    }

	    //Read all records
	    @GetMapping("/getAllOrder")
	    public List<OrderEntity> getAllOrder(){
	        return orderService.getAllOrder();
	    }

	    //Read a record by Orderitemname
	    @GetMapping("/getByOrderid")
	    public List<OrderEntity> findByOrderid(@RequestParam int orderid) {
	        return orderService.findByOrderid(orderid);
	    }
	    //Update a record
	    @PutMapping("/putOrder")
	    public OrderEntity putOrder(@RequestParam int orderid,    @RequestBody OrderEntity newOrderDetails) throws Exception {
	        return orderService.putOrder(orderid, newOrderDetails);
	    }
	    
	    @CrossOrigin
	    @DeleteMapping("deleteOrder/{orderid}")
	    public String deleteOrder(@PathVariable int orderid) {
	        return orderService.deleteOrder(orderid);
	    }
	    
	    @GetMapping("/orderbycustomer")
	    public List<OrderEntity> findOrderbyCustomer(@RequestBody CustomerEntity customer){
	    	List<OrderEntity> order = new ArrayList<OrderEntity>();
	    	List<OrderEntity> order1 = new ArrayList<OrderEntity>();
	    	
	    	order1 = orderService.getAllOrder();
	    	for(int i=0;i<order1.size();i++) {
	    		if(order1.get(i).getCustomer() == customer){
	    			System.out.println("True");
	    		}
	    		else {
	    			System.out.println(order1.get(i).getCustomer());
	    			
	    		}
	    	}
	    	
	    	return order;
	    	
	    }
	    

}
