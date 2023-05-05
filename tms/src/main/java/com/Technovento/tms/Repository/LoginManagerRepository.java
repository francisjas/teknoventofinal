package com.Technovento.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento.tms.Entity.LoginManagerEntity;

public interface LoginManagerRepository  extends JpaRepository<LoginManagerEntity, Integer>{
	LoginManagerEntity findByLoginid(int loginid);

}
