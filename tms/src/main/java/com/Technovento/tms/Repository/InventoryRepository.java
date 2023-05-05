package com.Technovento.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento.tms.Entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Integer>{
	InventoryEntity findByItemname(String itemname);
}

