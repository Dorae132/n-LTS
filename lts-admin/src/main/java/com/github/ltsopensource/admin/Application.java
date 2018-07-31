package com.github.ltsopensource.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.github.ltsopensource.admin.support.SystemInitListener;
import com.github.ltsopensource.admin.web.filter.LoginAuthFilter;

@SpringBootApplication
@ImportResource({"classpath:spring-core.xml", "classpath:spring-web.xml"})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}
	
	/***filter***/
	@Bean
	public FilterRegistrationBean someFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(loginAuthFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.addInitParameter("auth-config", "auth.cfg");
		registrationBean.setName("loginAuthFilter");
		return registrationBean;
	}
	
//	@Bean(name = "loginAuthFilter")
	public LoginAuthFilter loginAuthFilter() {
		LoginAuthFilter loginAuthFilter = new LoginAuthFilter();
		return loginAuthFilter;
	}
	
	/**listener**/
	@Bean
	public ServletListenerRegistrationBean systemInitListener() {
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new SystemInitListener());
		return servletListenerRegistrationBean;
	}
	
	/*@Bean
	public ServletListenerRegistrationBean contextLoaderListener() {
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new ContextLoaderListener());
		return servletListenerRegistrationBean;
	}*/
}
