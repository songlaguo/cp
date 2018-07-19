package org.bc.saas.web.config;

import org.bc.saas.common.utils.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;

 

import feign.RequestInterceptor;

//@Configuration
public class FeignConfig {
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
			if (!StringUtils.isEmpty(sessionId)) {
				requestTemplate.header("Cookies", "SESSION=" + sessionId);
			}
		};
	}
}
