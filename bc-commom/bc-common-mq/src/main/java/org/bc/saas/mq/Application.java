package org.bc.saas.mq;

import org.bc.saas.common.interceptor.ExceptionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("org.bc.saas.mq.persistence")
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
