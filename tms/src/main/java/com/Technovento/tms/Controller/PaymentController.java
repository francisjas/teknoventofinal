package com.Technovento.tms.Controller;

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

import com.Technovento.tms.Entity.PaymentEntity;
import com.Technovento.tms.Service.OrderService;
import com.Technovento.tms.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService pserv;
    @Autowired
    OrderService oserv;
  
    @GetMapping("/print")
    public String printHelloStudent() {
         return "Hello, Student!";
    }
    
    //Create or insert an payment method
    @CrossOrigin
    @PostMapping("/postPayment")
    public PaymentEntity insertPaymentOrder(@RequestBody PaymentEntity payment) {
    	try {
			oserv.updateRemaining(payment.getOrder().getOrderid(),payment.getCash());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pserv.insertPayment(payment);
    }
    
    //Read all payments
    @GetMapping("/getAllPayment")
    public List<PaymentEntity> getAllPayment(){
        return pserv.getAllPayment();
    }
    
    //Read a record by Paymentid
    @GetMapping("/getByPaymentcustomerusername")
    public PaymentEntity findbyPaymentid(@RequestParam int paymentid) {
    	return pserv.findByPaymentid(paymentid);
    }
    //Update a payment
    @PutMapping("/putPayment")
    public PaymentEntity putPayment(@RequestParam int paymentid,    @RequestBody PaymentEntity newPaymentDetails) throws Exception {
    	return pserv.putPayment(paymentid, newPaymentDetails);
    }
    
    @DeleteMapping("deletePayment/{paymentid}")
    public String deletePayment(@PathVariable int paymentid) {
        return pserv.deletePayment(paymentid);
    }
}