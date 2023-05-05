package com.Technovento.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento.tms.Entity.ManagerEntity;
import com.Technovento.tms.Repository.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	ManagerRepository mrepo;
	
//Read all records from tbl_course
	
    public List<ManagerEntity> getAllManager(){
        return mrepo.findAll();
    }
//C - Create or insert a course record
    public ManagerEntity insertManager(ManagerEntity customer) {
        return mrepo.save(customer);
    }
//R - Read or search course record by Code
    public ManagerEntity findByUsername(String username) {
        if (mrepo.findByUsername(username) != null)
            return mrepo.findByUsername(username);
        else
            return null;
    } 
  //U - Update a course record
    public ManagerEntity putManager(int id,ManagerEntity newItemDetails) throws Exception{
    	ManagerEntity item = new ManagerEntity();
    	try {
    		item = mrepo.findById(id).get();
    		item.setUsername(newItemDetails.getUsername());
    		item.setFirstname(newItemDetails.getFirstname());
    		item.setLastname(newItemDetails.getLastname());
    		item.setPassword(newItemDetails.getPassword());
    		item.setAge(newItemDetails.getAge());
    		item.setSalary(newItemDetails.getSalary());
    		return mrepo.save(item);
    		
    	}catch(NoSuchElementException nex){
    		throw new Exception("ID number "+id+" does not exist!");
    	}
    	
    }
  //D - Delete a manager record
    public String deleteManager(int id) {
        String msg;
        if(mrepo.findById(id) != null) {
        	mrepo.deleteById(id); //find the id number of the student to be deleted
            msg = "Item ID Number: " + id + " was successfully deleted!";
        } else {
            msg = "Item ID Number: " + id + " was NOT found!";
        }
        
        return msg;
    }
    
    public ManagerEntity findManagerById(int id) {
        if (mrepo.findById(id) != null)
            return mrepo.findById(id).get();
        else
            return null;
    } 
    
    
    public boolean ManagerLogin(String username, String password){
    	boolean temp = false;
    	ManagerEntity manager = new ManagerEntity();
    	if(mrepo.findByUsername(username) != null) {
    		manager = mrepo.findByUsername(username);
    		if(manager.getPassword().equals(password)){
    			System.out.println(manager.getPassword());
    			temp = true;
    		}
    	}
    	return temp;
    	
    }
}
