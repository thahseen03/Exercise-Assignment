/**
 * 
 */
package com.amdocs.UserMS.UserMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ikramshariff
 *
 */
@RestController
public class Controller {
	
	
	
	@GetMapping("/")
	public String getWelcome(){
		return "<h1>Welcome for All</h1>";
	}
	
	
	
	@GetMapping("/user")
	public RequestObject getUser(Authentication auth){
		
		/*
		 * String apiUrl = "http://localhost:8083/profiles/"; RequestObject
		 * requestObject = new RequestObject();
		 * requestObject.setUsername(auth.getName());
		 * 
		 * RestTemplate restTemplate = new RestTemplate(); ResponseObject response =
		 * restTemplate.postForObject(apiUrl, requestObject, ResponseObject.class);
		 */
		RequestObject request =new RequestObject();
		request.setUsername(auth.getName());
		return request;
	}

}
