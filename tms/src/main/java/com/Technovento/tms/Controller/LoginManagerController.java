package com.Technovento.tms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technovento.tms.Entity.LoginManagerEntity;
import com.Technovento.tms.Service.LoginManagerService;
import com.Technovento.tms.Service.ManagerService;

@RestController
@RequestMapping("/loginmanager")
public class LoginManagerController {
	@Autowired
	LoginManagerService lserv;
	@Autowired
	ManagerService mserv;
	
	@CrossOrigin
	  @PostMapping("/Manager")
	  public String loginCustomer(@RequestParam String username, @RequestParam String password,@RequestBody LoginManagerEntity loginmanager) {
	      if(mserv.ManagerLogin(username, password)) {
	    	  lserv.insertLogin(loginmanager,username);
	          return "Login Successful";
	      }
	      else {
	    	  return "Invalid Credentials";
	      }
		  
	  }
	
	@GetMapping("/displayLoginManager")
    public List<LoginManagerEntity> getAllManager(){
        return lserv.getAllManager();
    }
	
	 @DeleteMapping("deleteLogin/{id}")
	  public String deleteLogin(@PathVariable int id) {
	      return lserv.deleteLoginCustomer(id);
	  }
	  
	  @CrossOrigin
	  @DeleteMapping("deleteAllLogin")
	  public String deleteLogin() {
	      return lserv.deleteAll();
	  }
	  
	
}
