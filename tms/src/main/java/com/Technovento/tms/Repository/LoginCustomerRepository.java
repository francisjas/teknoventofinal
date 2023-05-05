package com.Technovento.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento.tms.Entity.LoginCustomerEntity;

public interface LoginCustomerRepository extends JpaRepository<LoginCustomerEntity,Integer>{
	LoginCustomerEntity findByLoginid(int loginid);
}
