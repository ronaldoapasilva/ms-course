package com.silvaronaldo.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.silvaronaldo.hrpayroll.entities.Payment;

//@Component
@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
