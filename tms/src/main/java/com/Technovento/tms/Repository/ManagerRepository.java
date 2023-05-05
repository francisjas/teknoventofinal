package com.Technovento.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento.tms.Entity.ManagerEntity;

public interface ManagerRepository extends JpaRepository<ManagerEntity,Integer>{
	ManagerEntity findByUsername(String username);

}
