/**
 * 
 */
package com.amdocs.media.assignement.profileservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amdocs.media.assignement.profileservice.entity.ProfileEntity;
import com.amdocs.media.assignement.profileservice.entity.RestTemplateVo;
import com.amdocs.media.assignement.profileservice.entity.UserVo;
import com.amdocs.media.assignement.profileservice.service.KafkaProducer;
import com.amdocs.media.assignement.profileservice.service.ProfileServiceInterface;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

/**
 * @author ikramshariff
 *
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	
	private KafkaProducer kafkaProducer;
	
	
	public ProfileController(KafkaProducer kafkaProducer) {
		this.kafkaProducer= kafkaProducer;
	}
	
	@Autowired
	private ProfileServiceInterface service;
	
	@GetMapping("/show")
	public String extractUserName(String token) {
	
		String user = null;
        if (token != null) {
            // parse the token.

            try {
                user = Jwts.parser()
                        .setSigningKey("secretkey")
                        .parseClaimsJws(token.replace("Bearer", ""))
                        .getBody()
                        .getSubject();


            } catch (Exception e) {

                throw e;

            }
		
		
        }
        
        kafkaProducer.sendMessage("success");
        return user;
        
		
	}
	
	
	
	 
	
	@PostMapping("/")
	public ProfileEntity saveProfileEntity(HttpServletRequest request, @RequestHeader(value="Authorization") String authToken,@RequestBody ProfileEntity profile) {
		String token = request.getHeader("Authorization");
		profile.setUsername(extractUserName(token));
		
		return service.saveProfile(profile);
		
		
	}
	
	@GetMapping("/get")
	public List<ProfileEntity> getAllProfiles(){
		List<ProfileEntity> list =new ArrayList<ProfileEntity>();

		list=service.getAllProfiles();
		return list;
	}
	
	@PutMapping("/")
	public ProfileEntity updateProfile(HttpServletRequest request, @RequestHeader(value="Authorization") String authToken, @RequestBody ProfileEntity profile) {
		String token = request.getHeader("Authorization");
		profile.setUsername(extractUserName(token));
		ProfileEntity tempProfile= service.updateProfileByUserName(profile.getUsername(), profile);
		String message ="Profile for username " + profile.getUsername() + " updated";
		kafkaProducer.sendMessage(message);
		return tempProfile;
		
	}
	
	@DeleteMapping("/")
	public String deleteProfile(HttpServletRequest request, @RequestHeader(value="Authorization") String authToken) {
		String token = request.getHeader("Authorization");
		ProfileEntity profile =new ProfileEntity();
		profile.setUsername(extractUserName(token));
		service.deleteProfileById(profile.getUsername());
		String message ="Profile for username " + profile.getUsername() + " deleted";
		kafkaProducer.sendMessage(message);
		return "Deleted";
	}

}
