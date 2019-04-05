package com.springsecurity.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() { // TODO
	 * Auto-generated method stub List<UserDetails> users=new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("surendra").password(
	 * "12061994").roles("user").build());
	 * //users.add(User.withDefaultPasswordEncoder().username("sahoo").password(
	 * "kunal").roles("ADMIN").build()); return new
	 * InMemoryUserDetailsManager(users); }
	 */

	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setUserDetailsService(userDetailsService);
		daoAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		return daoAuthProvider;

	}

}
