package com.intiFormation.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // indique que cette classe est une classe de configuration
@EnableWebSecurity // active la sécurité Web
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired // injection de dépendance : Spring fournit une instance de UserDetailsService
	private UserDetailsService userDetailsService;
	
	@Autowired // injection de dépendance : Spring fournit une instance de RequestFilter
	RequestFilter requestFilter;
	


	// configuration de l'authentification
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService); // utilisation de UserDetailsService pour charger les utilisateurs enregistrés
	}
	
	// configuration de l'autorisation
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(). // protection CSRF
				authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/api/loginUserJwt").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	// configuration du chiffrement des mots de passe
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	// configuration du gestionnaire d'authentification
	@Bean 
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}

	
	
	
	
}
