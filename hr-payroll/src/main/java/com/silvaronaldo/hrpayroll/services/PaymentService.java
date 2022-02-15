package com.silvaronaldo.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.silvaronaldo.hrpayroll.entities.Payment;
import com.silvaronaldo.hrpayroll.entities.Worker;

//@Component
@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
	
		//precisa ser String String, parametros no HTTP sempre string
		//mapa, dicionário de parametros
		Map<String, String> uriVariables = new HashMap<>();
		
		//""+ converter para string
		uriVariables.put("id", ""+workerId);
				
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables); 
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
		//return new Payment("Bob", 200.0, days);
	}
}
