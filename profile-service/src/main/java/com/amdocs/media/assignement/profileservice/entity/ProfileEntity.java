/**
 * 
 */
package com.amdocs.media.assignement.profileservice.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 
 *
 */
@Entity
@Table(name="Profile_Service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProfileEntity {
	
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; public
	 * Long getId() { return id; } public void setId(Long id) { this.id = id; }
	 */
	public String getUsername() {
		return username;}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	private String address;
	private String phoneNumber;

}
