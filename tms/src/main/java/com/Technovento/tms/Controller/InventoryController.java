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

import com.Technovento.tms.Entity.InventoryEntity;
import com.Technovento.tms.Service.InventoryService;



@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
    InventoryService invserv;
	
	
	 //printHelloStudent
    @GetMapping("/print")
    public String printHelloStudent() {
         return "Hello, Student!";
    }
    

    //Read
    @GetMapping("/displayAllItems")
    public List<InventoryEntity> getAllItems(){
        return invserv.getAllItem();
    }
    
  //Create or insert a item record
    @CrossOrigin
    @PostMapping("/postItem")
    public InventoryEntity insertItem(@RequestBody InventoryEntity item) {
        return invserv.insertItems(item);
    }
  
    //Read a record by itemName
    @GetMapping("/getByItemName")
    public List<InventoryEntity> findByItemName(@RequestParam String itemname) {
    	List<InventoryEntity> en = new ArrayList<InventoryEntity>();
    	en.add(invserv.findByItemName(itemname));
        return en;
    }
    @CrossOrigin
    @PutMapping("/putItem")
    public InventoryEntity putItem(@RequestParam int id,    @RequestBody InventoryEntity newItemDetails) throws Exception {
        return invserv.putItem(id, newItemDetails);
    }
    @CrossOrigin
    @DeleteMapping("deleteItem/{id}")
    public String deleteItem(@PathVariable int id) {
        return invserv.deleteItem(id);
    }
    
    @DeleteMapping("deleteItem")
    public String deleteAllItem() {
        return invserv.deleteAll();
    }
}
