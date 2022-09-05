/**
 * 
 */
package com.amdocs.media.assignement.profileservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.amdocs.media.assignement.profileservice.dao.ProfileEnityDao;
import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;
import com.amdocs.media.assignement.profileservice.exception.ResourceNotFoundException;
import com.amdocs.media.assignement.profileservice.service.ProfileServiceInterface;

/**
 * @author ikramshariff
 *
 */
@SpringBootTest
public class ServiceClassTests {
	
	@Autowired
	private ProfileServiceInterface profileService;
	
	@MockBean
	private ProfileEnityDao dao;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	public void test_saveProfile() {
		ProfileEntity profile1 = new ProfileEntity();
		profile1.setUsername("user1");
		profile1.setAddress("East Coast");
		profile1.setPhoneNumber("4539876543");
		
		Mockito.when(dao.save(profile1)).thenReturn(profile1);
		
		assertEquals(profile1, profileService.saveProfile(profile1));
	}
	
	@Test
	public void test_updateProfileByUserName() {
		ProfileEntity profile = new ProfileEntity();
		 String userName = "user1";
		 profile.setUsername("user1");
			profile.setAddress("East Coast");
			profile.setPhoneNumber("4539876543");
		 
		 
		 Mockito.when(dao.findById(userName)).thenReturn(Optional.of(profile));
		 Mockito.when(dao.save(profile)).thenReturn(profile);
		 
		 
		 assertEquals(profile, profileService.updateProfileByUserName(userName, profile));
	}
	
	
	

}
