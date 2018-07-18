package org.bc.mq.config;

import org.bc.mq.vo.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

@Configuration
public class RabbitExchangeConfig {
	// String EXCHANGE_NAME;
	// String QUEUE_NAME;
	// String ROUTING_KEY;
	//
	// public RabbitExchangeConfig(String EXCHANGE_NAME, String QUEUE_NAME, String ROUTING_KEY) {
	// this.EXCHANGE_NAME = EXCHANGE_NAME;
	// this.QUEUE_NAME = QUEUE_NAME;
	// this.ROUTING_KEY = ROUTING_KEY;
	// }
	// topic交换机
	@Bean
	public TopicExchange defaultExchange() {
		return new TopicExchange("exchange");
	}

	// 队列
	@Bean
	public Queue queue() {
		return QueueBuilder.durable(RabbitConstant.TEST_TOPIC).build();
	}

	// 绑定
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(this.queue()).to(this.defaultExchange()).with(RabbitConstant.TEST_TOPIC);
	}
}
