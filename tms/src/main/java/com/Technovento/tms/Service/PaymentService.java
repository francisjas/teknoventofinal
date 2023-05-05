package com.Technovento.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento.tms.Entity.PaymentEntity;
import com.Technovento.tms.Repository.OrderRepository;
import com.Technovento.tms.Repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository prepo;
	OrderRepository orepo;
	
	
	//C - Create or insert an order record
		public PaymentEntity insertPayment(PaymentEntity payment) {
			return prepo.save(payment);
		}
		
		//R - Read all records from tbl_order
		public List<PaymentEntity> getAllPayment(){
	        return prepo.findAll();
	    }
		
		//R - Read or search student record by order item name
		public PaymentEntity findByPaymentid(int paymentid) {
			if (prepo.findByPaymentid(paymentid) != null)
				return prepo.findByPaymentid(paymentid);
			else
				return null;
		}
		//U - Update a Payment record
		public PaymentEntity putPayment(int paymentid, PaymentEntity newOrderDetails) throws Exception{
			
			PaymentEntity payment = new PaymentEntity();
			
			try {
				 //Search the ID number of an payment
				payment = prepo.findById(paymentid).get();
	            //update the payment record
				payment.setPaymentmethod(newOrderDetails.getPaymentmethod());
				payment.setCash(newOrderDetails.getCash());
				if(payment.getCash() > newOrderDetails.getCash()) {
					double temp = payment.getCash() - newOrderDetails.getCash();
					payment.getOrder().setRemainingpayment(temp + payment.getOrder().getRemainingpayment());
				}
				else if(payment.getCash() < newOrderDetails.getCash()) {
					double temp = newOrderDetails.getCash()- payment.getCash() ;
					payment.getOrder().setRemainingpayment(temp - payment.getOrder().getRemainingpayment());
				}
				 //Save the information and return the value
				return prepo.save(payment);
			}catch(NoSuchElementException nex) {
				 //throws an error if the id does not exist
				throw new Exception("Order ID Number "+ paymentid + "does not exist");
			}
		}
			
			//D- Delete order record
			public String deletePayment(int paymentid) {
				String msg;
				if(prepo.findById(paymentid) != null) {
					prepo.deleteById(paymentid);//find the order id number of the customer to be deleted
					msg = "Payment ID Number " + paymentid + " is successfully deleted!";
				}
				else 
					msg = "Payment ID Number" + paymentid + "is NOT found!";
				return msg;
			}
}
