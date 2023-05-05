package com.Technovento.tms.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento.tms.Entity.LoginManagerEntity;
import com.Technovento.tms.Entity.ManagerEntity;
import com.Technovento.tms.Repository.LoginManagerRepository;

@Service
public class LoginManagerService {
	@Autowired
	LoginManagerRepository lmrepo;
	
	@Autowired
	ManagerService mserv;
	
	public LoginManagerEntity insertLogin(LoginManagerEntity loginC, String username) {
		ManagerEntity m = new ManagerEntity();
		m = mserv.findByUsername(username);
		loginC.setUsername(m.getUsername());
		loginC.setPassword(m.getPassword());
		loginC.setManager(m);;
		return lmrepo.save(loginC);
	}
	
	public List<LoginManagerEntity> getAllManager(){
        return  lmrepo.findAll();
    }
	
	 public String deleteLoginCustomer(int id) {
	        String msg;
	        if(lmrepo.findById(id) != null) {
	        	lmrepo.deleteById(id); //find the id number of the student to be deleted
	            msg = "Login ID Number: " + id + " was successfully deleted!";
	        } else {
	            msg = "Login ID Number: " + id + " was NOT found!";
	        }
	        
	        return msg;
	    }
	 
	 public String deleteAll() {
		 lmrepo.deleteAll();
	        return "Everything Deleted";
	    }
}
