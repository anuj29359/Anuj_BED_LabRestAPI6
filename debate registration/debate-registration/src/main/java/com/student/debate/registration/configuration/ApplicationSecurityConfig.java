package com.student.debate.registration.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//Authentication
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
		.and()
		.withUser("user").password(passwordEncoder().encode("user")).roles("USER");;
	}
	
	
	
	//Authorization
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.cors().disable();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		
		httpSecurity.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/student/**")
				.hasAnyRole("USER", "ADMIN")
				.antMatchers("/h2-console/**", "/login/**", "/swagger-ui.html/**")
				.permitAll()
				.and().authorizeRequests().antMatchers(HttpMethod.POST, "/student/**")
				.hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/student/**")
				.hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/student/**")
				.hasRole("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().and().httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
		
		
	}
}

