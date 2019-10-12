package com.yishuifengxiao.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.yishuifengxiao.common.properties.SecurityProperties;
import com.yishuifengxiao.common.security.manager.SecurityContextManager;

/**
 * 安全服务器配置
 * 
 * @author yishui
 * @date 2018年11月19日
 * @Version 0.0.1
 */
public abstract class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 自定义属性配置
	 */
	@Autowired
	protected SecurityProperties securityProperties;

	/**
	 * 自定义密码加密类
	 */
	@Autowired
	protected PasswordEncoder passwordEncoder;
	/**
	 * 自定义UserDetailsService实现类，查找用户
	 */
	@Autowired
	protected UserDetailsService userDetailsService;

	/**
	 * 安全授权配置管理器
	 */
	@Autowired
	protected SecurityContextManager securityContextManager;

	/**
	 * 定义在security-core包中
	 */
	@Autowired(required = false)
	@Qualifier("exceptionAuthenticationEntryPoint")
	protected AuthenticationEntryPoint exceptionAuthenticationEntryPoint;

	/**
	 * 权限拒绝管理器
	 */
	@Autowired
	protected AccessDeniedHandler customAccessDeniedHandler;

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {

		// @formatter:off
		// auth.inMemoryAuthentication().withUser("yishui").password(passwordEncoder.encode("12345678")).roles("ADMIN").and()
		// .withUser("bob").password("abc123").roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		// @formatter:on
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		applyAuthenticationConfig(http);
	}
	
	/**
	 * 默认的spring security配置【需要在子类中调用此方法】
	 * 
	 * @param http
	 * @throws Exception
	 */
	protected void applyAuthenticationConfig(HttpSecurity http) throws Exception {

		// @formatter:off




	
	
//		// 添加全局异常处理
//		if (exceptionAuthenticationEntryPoint != null) {
//			http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
//					.authenticationEntryPoint(exceptionAuthenticationEntryPoint);
//		}

		// 注入所有的自定义授权适配器
		securityContextManager.config(http);

		// .anonymous().disable()//禁止匿名访问要放在后面
		// @formatter:on

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * 设置忽视的目录
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// @formatter:off
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").mvcMatchers(securityProperties.getIgnore().getIgnore())
				.antMatchers(securityProperties.getIgnore().getIgnore())// 设置忽视目录
		;
		// .antMatchers("/**/**.js", "/lang/*.json", "/**/**.css", "/**/**.js",
		// "/**/**.map", "/**/**.html","/**/**.jsp",
		// "/**/**.png")
		// .antMatchers("/zui/**","/js/**","/images/**")
		// .antMatchers("/uuac/zui/**","/uuac/js/**","/uuac/images/**")
		// .antMatchers("/webjars/**", "/images/**",
		// "/swagger-ui.html","/swagger-resources/**","/v2/api-docs","/configuration/ui","/configuration/security","/actuator/**");
		// @formatter:on
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}


}