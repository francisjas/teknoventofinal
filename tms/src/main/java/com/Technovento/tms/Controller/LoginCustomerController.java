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

import com.Technovento.tms.Entity.LoginCustomerEntity;
import com.Technovento.tms.Service.CustomerService;
import com.Technovento.tms.Service.LoginCustomerService;

@RestController
@RequestMapping("/logincustomer")
public class LoginCustomerController {
  @Autowired
  LoginCustomerService lserv;
  @Autowired
  CustomerService cserv;
  
  @CrossOrigin
  @PostMapping("/Customer")
  public String loginCustomer(@RequestParam String username, @RequestParam String password,@RequestBody LoginCustomerEntity logincustomer) {
      if(cserv.CustomerLogin(username, password)) {
    	  lserv.insertLogin(logincustomer,username);
          return "Login Successful";
      }
      else {
    	  return "Invalid Credentials";
      }
  }
  @GetMapping("/displayloggedCustomer")
  public List<LoginCustomerEntity> getLoggedCustomer(){
      return lserv.getAllCustomer();
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
