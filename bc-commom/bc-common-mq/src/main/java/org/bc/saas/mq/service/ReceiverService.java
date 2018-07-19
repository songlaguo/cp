package org.bc.saas.mq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import org.bc.saas.common.entity.User;
import org.bc.saas.mq.vo.RabbitConstant;

@Component
@RabbitListener(queues = RabbitConstant.TEST_TOPIC)
public class ReceiverService {
	@RabbitHandler
	public void process(String hello) {
		User user = JSON.parseObject(hello, User.class);
		System.out.println("==***===Receiver  user: " + JSON.toJSONString(hello));
		System.out.println("==***===Receiver  name: " + user.getName());
	}
}
