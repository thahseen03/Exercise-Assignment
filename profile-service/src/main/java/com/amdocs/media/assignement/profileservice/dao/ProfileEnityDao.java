package com.amdocs.media.assignement.profileservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;

@Repository

public interface ProfileEnityDao extends JpaRepository<ProfileEntity, String> {

}
