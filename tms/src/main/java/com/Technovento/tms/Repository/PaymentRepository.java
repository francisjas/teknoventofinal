package com.Technovento.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento.tms.Entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Integer>{
	PaymentEntity findByPaymentid(int paymentid);
}
