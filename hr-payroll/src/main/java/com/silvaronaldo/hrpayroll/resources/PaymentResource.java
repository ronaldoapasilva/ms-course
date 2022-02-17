package com.silvaronaldo.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.silvaronaldo.hrpayroll.entities.Payment;
import com.silvaronaldo.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workedId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workedId, @PathVariable Integer days){
		Payment payment = service.getPayment(workedId, days);
		return ResponseEntity.ok(payment);
	}
	
	//ystrix caminho alternativo para qdo o serviço não estiver funcionando 
	public ResponseEntity<Payment> getPaymentAlternative(Long workedId, @PathVariable Integer days){
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
