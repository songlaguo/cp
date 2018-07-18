package org.bc.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.bc.common.interceptor.ExceptionInterceptor;

@SpringBootApplication
@MapperScan("org.bc.mq.persistence")
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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
