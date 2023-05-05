package com.Technovento.tms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technovento.tms.Entity.CustomerEntity;
import com.Technovento.tms.Entity.OrderEntity;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByOrderid(int orderid);
    List<OrderEntity> findByCustomer(CustomerEntity customer);
}