/**
 * 
 */
package org.bc.saas.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 功能概述：dubbo 配置
 *
 * 创建时间：2018/1/30 10:23
 *
 * 修改记录：
 *
 * @author Frank
 */
@Configuration
@ImportResource({"classpath:spring/spring-config-dubbo-*.xml"})
public class DubboConfig {
}
