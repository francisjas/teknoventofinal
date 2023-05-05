package com.Technovento.tms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento.tms.Entity.CustomerEntity;
import com.Technovento.tms.Entity.LoginCustomerEntity;
import com.Technovento.tms.Repository.LoginCustomerRepository;

@Service
public class LoginCustomerService {
	@Autowired
	LoginCustomerRepository lrepo;
	
	 @Autowired
	  CustomerService cserv;
	
	public LoginCustomerEntity insertLogin(LoginCustomerEntity loginC, String username) {
		CustomerEntity c = new CustomerEntity();
		c = cserv.findByUsername(username);
		loginC.setUsername(c.getUsername());
		loginC.setPassword(c.getPassword());
		loginC.setCustomer(c);
		return lrepo.save(loginC);
	}
	
	public List<LoginCustomerEntity> getAllCustomer(){
        return  lrepo.findAll();
    }
	
	 public String deleteLoginCustomer(int id) {
	        String msg;
	        if(lrepo.findById(id) != null) {
	        	lrepo.deleteById(id); //find the id number of the student to be deleted
	            msg = "Login ID Number: " + id + " was successfully deleted!";
	        } else {
	            msg = "Login ID Number: " + id + " was NOT found!";
	        }
	        
	        return msg;
	    }
	 
	 public String deleteAll() {
	        lrepo.deleteAll();
	        return "Everything Deleted";
	    }
}
