package com.silvaronaldo.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvaronaldo.hrpayroll.entities.Payment;
import com.silvaronaldo.hrpayroll.entities.Worker;
import com.silvaronaldo.hrpayroll.feignclients.WorkerFeignClient;

//@Component

@Service
public class PaymentService {
	
	//agora será usado o feign e não mais RestTamplate
	
	//pegar o valro da variavel hr-worker.host 
	//no arquivo application.properties
//	@Value("${hr-worker.host}")
//	private String workerHost;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	
	@Autowired 
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	
	}
//	
//	public Payment getPayment(long workerId, int days) {
//	
//		//precisa ser String String, parametros no HTTP sempre string
//		//mapa, dicionário de parametros
//		Map<String, String> uriVariables = new HashMap<>();
//		
//		//""+ converter para string
//		uriVariables.put("id", ""+workerId);
//				
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables); 
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
//		
//		//return new Payment("Bob", 200.0, days);
//	}
}
