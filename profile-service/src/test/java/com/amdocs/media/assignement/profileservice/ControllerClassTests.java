/**
 * 
 */
package com.amdocs.media.assignement.profileservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;
import com.amdocs.media.assignement.profileservice.service.ProfileServiceInterface;

/**
 * @author ikramshariff
 *
 */


@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.amdocs.media.assignement"})

public class ControllerClassTests {
	
	
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProfileServiceInterface service;
	
	
	
	@BeforeEach
	public void setUp() {
		ProfileEntity profile =new ProfileEntity();
		profile.setUsername("user1");
		profile.setAddress("east coast");
		profile.setPhoneNumber("123456789");
		
	}
	
	@Test
	public void test_saveProfile() throws Exception {
		
		ProfileEntity inputProfile = new ProfileEntity();
		inputProfile.setUsername("user1");
		inputProfile.setAddress("east coast");
		inputProfile.setPhoneNumber("123456789");
		
		Mockito.when(service.saveProfile(inputProfile)).thenReturn(inputProfile);
		
		mockMvc.perform(post("/profile")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{\n" +
		        		 
		                "\t\"address\":\"east coast\",\n" +
		                "\t\"phoneNumber\":\"123456789\",\n" +
		                 
		                "}"))
		                .andExpect(status().isBadRequest());
		
		
	}
	
	@Test
	public void test_updateProfile() throws Exception {
		
		ProfileEntity inputProfile = new ProfileEntity();
		inputProfile.setUsername("user1");
		inputProfile.setAddress("east coast");
		inputProfile.setPhoneNumber("123456789");
		
		Mockito.when(service.updateProfileByUserName(inputProfile.getUsername(),inputProfile)).thenReturn(inputProfile);
		
		mockMvc.perform(put("/profile")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{\n" +
		        		 
		                "\t\"address\":\"east coast\",\n" +
		                "\t\"phoneNumber\":\"123456789\",\n" +
		                 
		                "}"))
		                .andExpect(status().isBadRequest());
		
		
	}
	
	
	
	
	

}
