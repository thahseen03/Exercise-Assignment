/**
 * 
 */
package com.amdocs.UserMS.UserMS;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ikramshariff
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery("select username ,password ,enabled from users where username =?")
		.authoritiesByUsernameQuery("select username ,authority from authorities where username=?");
		
		
	
		 		
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN","USER")
		.antMatchers("/","static/js").permitAll()
		.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

}
