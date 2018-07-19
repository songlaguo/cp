package org.bc.saas.mq.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.bc.saas.common.entity.User;
import org.bc.saas.mq.config.RabbitConfig;
import org.bc.saas.mq.config.RabbitExchangeConfig;

import com.rabbitmq.client.Channel;

//@Configuration
public class RabbitReceive {
	@Autowired
	private RabbitConfig rabbitConfig;
	@Autowired
	private RabbitExchangeConfig rabbitExchangeConfig;

	@Bean
	public SimpleMessageListenerContainer messageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(rabbitConfig.connectionFactory());
		container.setQueues(rabbitExchangeConfig.queue()); // 设置要监听的队列
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("<==========receive msg byte: " + new String(body));
				User user = (User) toObject(body);
				System.out.println("<==========receive msg User: " + user);
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // 确认消息成功消费
			}
		});
		return container;
	}

	private Object toObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return obj;
	}
}
