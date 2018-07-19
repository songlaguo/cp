package org.bc.saas.mq.controller;

import org.bc.saas.common.entity.User;
import org.bc.saas.mq.common.RabbitSender;
import org.bc.saas.mq.vo.MisEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
 

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/v1/" })
public class SendTestController {
	@Autowired
	private RabbitSender sender;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ApiOperation(value = "发送", notes = "发送", tags = "v1.0.0")
	public void sender() {
		User user = new User();
		user.setName("张三");
		user.setLogonid("zhangsan");
		user.setMobile("13333333333333");
		sender.sendMsg(JSON.toJSONString(user));
	}

	@RequestMapping(value = "send", method = RequestMethod.GET)
	@ApiOperation(value = "kafka发送", notes = "kafka发送", tags = "v1.0.0")
	public void sendKafka() {
		User user = new User();
		user.setName("张三");
		user.setLogonid("zhangsan");
		user.setMobile("13333333333333");
		String message = JSON.toJSONString(user);
		try {
			ListenableFuture y = kafkaTemplate.send("test", message);
			logger.info("发送kafka成功." + y);
		} catch (Exception e) {
			logger.error("发送kafka失败", e);
		}
	}

	@RequestMapping(value = "ems", method = RequestMethod.GET)
	@ApiOperation(value = "kafka发送", notes = "kafka发送", tags = "v1.0.0")
	public void sendemsKafka() {
		MisEmployee ee = new MisEmployee();
		ee.setAddr("addr");
		ee.setAreaCode("areaCode");
		ee.setBirthday("birthday");
		ee.setCorp("1009");
		ee.setDeptCode("deptCode");
		ee.setEhrCode("23456");
		ee.setEhrId("1112223");
		ee.setEmpType("empType");
		ee.setIdCard("idCard");
		ee.setMobile("mobile");
		ee.setName("name");
		ee.setGender(0);
		ee.setPassword("111111");
		String supported = "1111/2222/3333";
		ee.setSupportedHosps(supported.toUpperCase().split("/"));
		String message = JSON.toJSONString(ee);
		try {
			ListenableFuture y = kafkaTemplate.send("ikangemployee", message);
			logger.info("发送kafka成功." + y);
		} catch (Exception e) {
			logger.error("发送kafka失败", e);
		}
	}
	// @KafkaListener(topics = { "test" })
	// public void listen(ConsumerRecord<?, ?> record) {
	// logger.info("kafka的key: " + record.key());
	// logger.info("kafka的value: " + record.value().toString());
	// }
}
