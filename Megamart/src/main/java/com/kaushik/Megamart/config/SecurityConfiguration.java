package com.kaushik.Megamart.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
   DataSource dataSource;
	
	//Enable jdbc authentication
   @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register").hasAnyRole("USER", "ADMIN")
				.antMatchers("/shop").hasAnyRole("USER", "ADMIN").antMatchers("/regi")
				.permitAll().anyRequest().authenticated()
				.and().formLogin().permitAll()
				.and().logout().permitAll();

		http.csrf().disable();
    }

   /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("kaushik").password("{noop}kaushik")
            .authorities("ROLE_USER").and().withUser("javainuse").password("{noop}javainuse")
            .authorities("ROLE_USER", "ROLE_ADMIN");
    }*/

}