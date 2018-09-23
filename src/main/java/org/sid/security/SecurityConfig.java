package org.sid.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
	.withUser("moez").password("{noop}123").roles("ADMIN"); 
	auth.inMemoryAuthentication()
	.withUser("user1").password("{noop}123").roles("USER");
}
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").permitAll();
		http
		.authorizeRequests()
		.antMatchers("/saveEntreprise","/newEntreprise")
		.hasRole("ADMIN");
	 http
	 .authorizeRequests()
	 .antMatchers("/entreprises","/taxes","/login").hasAnyRole("USER","ADMIN");
	}
}
