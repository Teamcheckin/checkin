package com.checkin.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http); // 주석해주면 다 허락하고, 선별적으로 들어오지 못하게 하는 것
		
		http
			.authorizeRequests() // 로그인 안 하고 여기로 가면
				.antMatchers("/admin/**").authenticated()
				.and()
			.formLogin() // 이리로 가라
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.and()
			.csrf() //csrf 설정을 일단 안 보이게
				.disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(auth);
		
		auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        // 사용자 정보를 가져오기
        .usersByUsernameQuery("select email id, password password, 1 enabled from member where email=?") 
        // 그 사용자의 역할 정보를 가져오기
        .authoritiesByUsernameQuery("select email id, positionId roleId from member where email=?");
		
//		auth
//			.inMemoryAuthentication()
//			.withUser("daryl@gmail.com")
//				.password("1111") 
//				.roles("ADMIN");
	}
}
