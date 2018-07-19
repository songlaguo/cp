package org.bc.saas.web;

 
import org.bc.saas.common.interceptor.ExceptionInterceptor;
import org.bc.saas.common.interceptor.LoginInterceptor;
import org.bc.saas.common.interceptor.MonitorInterceptor;
import org.bc.saas.common.interceptor.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

 

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = { "org.bc.saas.service.integration" })
@ComponentScan(basePackages = { "org.bc.saas" })
@MapperScan("org.bc.saas.persistence")
@EnableTransactionManagement
public class Application {
	/**
	 * redis
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 异常拦截器
	 * @return
	 */
	@Bean
	public ExceptionInterceptor exceptionInterceptor() {
		return new ExceptionInterceptor();
	}

	@Bean
	public PageInterceptor pageInterceptor() {
		return new PageInterceptor();
	}

	/**
	 * 登录拦截器 jishu070206
	 * @return
	 */
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Bean
	public MonitorInterceptor monitorInterceptor() {
		return new MonitorInterceptor();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
