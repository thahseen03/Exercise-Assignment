/**
 * 
 */
package com.amdocs.media.assignement.profileservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;






import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.test.context.web.WebAppConfiguration;

import com.amdocs.media.assignement.profileservice.dao.ProfileEnityDao;
import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;

/**
 * @author ikramshariff
 *
 */
@SpringBootTest(classes=ProfileServiceApplication.class)
@ComponentScan(basePackages = "com.amdocs.media.assignement.profileservice.dao")

@WebAppConfiguration
public class RepositoryClassTests  {
	
	@Autowired
	private ProfileEnityDao dao;
	
		
	@Test
	public void test_saveProfile() {
		
		ProfileEntity profile = new ProfileEntity();
		profile.setUsername("user1");
		profile.setAddress("east coast");
		profile.setPhoneNumber("12344567");
		
		
		
		ProfileEntity profile1=dao.save(profile);
		
		assertNotNull(profile1);
		assertEquals(profile1.getUsername(), "user1");
	}
	
	
	
	
	
	

}
