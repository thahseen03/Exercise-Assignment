package com.amdocs.media.assignement.profileservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;

@Service
public interface ProfileServiceInterface {
	
	public ProfileEntity saveProfile(ProfileEntity profileEntity);

	public List<ProfileEntity> getAllProfiles();
	
	public ProfileEntity updateProfileByUserName(String userName, ProfileEntity profile);
	
	public String deleteProfileById(String userName);
}
