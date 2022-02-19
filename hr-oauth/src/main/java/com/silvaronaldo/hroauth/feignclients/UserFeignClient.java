package com.silvaronaldo.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.silvaronaldo.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

	// exemplo /search?email=nina@gmail.com, atributo que usa depois do ? @RequestParam
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
		
}
