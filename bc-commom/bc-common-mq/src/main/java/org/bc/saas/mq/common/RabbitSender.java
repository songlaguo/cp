package org.bc.saas.mq.common;

import java.util.UUID;

import org.bc.saas.mq.vo.RabbitConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 

@Component
public class RabbitSender implements RabbitTemplate.ConfirmCallback {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(String content) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		this.rabbitTemplate.setConfirmCallback(this); // rabbitTemplate如果为单例的话，那回调就是最后设置的内容
		this.rabbitTemplate.convertAndSend("exchange", RabbitConstant.TEST_TOPIC, content, correlationId);
		System.out.println(" =======>send correlationId:" + correlationId);
		System.out.println(" =======>send msg:" + content);
	}

	// 回调
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("<======>回调id:" + correlationData);
		if (ack) {
			System.out.println("<======>消息成功消费");
		} else {
			System.out.println("<======>消息消费失败:" + cause);
		}
	}
}