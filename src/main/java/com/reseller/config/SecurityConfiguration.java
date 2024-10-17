package com.reseller.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://url here");
		dataSource.setUsername("username");
		dataSource.setPassword("password");
		dataSource.setMaxTotal(2);
		return dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
				.authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/resources/**", "/register", "/registerUser").permitAll()
				.antMatchers("/**").hasRole("USER").anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/login-success").failureUrl("/login-failure").loginProcessingUrl("/loginUser")
				.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutUser").permitAll();
		http.csrf().disable();
		http.sessionManagement().sessionFixation().migrateSession().invalidSessionUrl("/login")
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1).expiredUrl("/register")
				.maxSessionsPreventsLogin(false);
	}

}
