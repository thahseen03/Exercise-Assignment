/**
 * 
 */
package com.amdocs.media.assignement.profileservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.assignement.profileservice.dao.ProfileEnityDao;
import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;
import com.amdocs.media.assignement.profileservice.exception.ResourceNotFoundException;

/**
 * @author ikramshariff
 *
 */
@Service
public class ProfileServiceImpl implements ProfileServiceInterface {

	@Autowired
	ProfileEnityDao dao;
	
	@Override
	public ProfileEntity saveProfile(ProfileEntity profile) {
		
		
		return dao.save(profile);
	}
	
	public List<ProfileEntity> getAllProfiles()
	{
		List<ProfileEntity> list =new ArrayList<ProfileEntity>();
		list =dao.findAll();
		return list;
	}

	@Override
	public ProfileEntity updateProfileByUserName(String userName, ProfileEntity profile) {
		ProfileEntity tempProfile = dao.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Profile not exist with username: " + userName));
		
		tempProfile.setAddress(profile.getAddress());
		tempProfile.setPhoneNumber(profile.getPhoneNumber());
		 profile= dao.save(tempProfile);
		
		return profile;
	}

	@Override
	public String deleteProfileById(String userName) {
		//ProfileEntity tempProfile = dao.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Profile not exist with username: " + userName));
		dao.deleteById(userName);
		return null;
	}

}
