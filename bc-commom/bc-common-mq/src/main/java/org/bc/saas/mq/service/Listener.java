package org.bc.saas.mq.service;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import org.bc.saas.common.entity.User;
import org.bc.saas.common.entity.UserOrgPermission;
import org.bc.saas.common.utils.StringUtils;
import org.bc.saas.mq.persistence.OrgHospMapper;
import org.bc.saas.mq.persistence.UserMapper;
import org.bc.saas.mq.persistence.UserOrgPermissionMapper;
import org.bc.saas.mq.vo.MisEmployee;

/**
 * Created by jishu070206 on 2018/5/24.
 */
@Component
public class Listener {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrgHospMapper orgHospMapper;
	@Autowired
	private UserOrgPermissionMapper userOrgPermissionMapper;

	@KafkaListener(topics = { "test" })
	public void listen(ConsumerRecord<?, ?> record) {
		User user = JSON.parseObject(record.value().toString(), User.class);
		System.out.println("==***===Receiver  user: " + JSON.toJSONString(user));
		System.out.println("==***===Receiver  name: " + user.getName());
		logger.info("kafka的key: " + record.key());
		logger.info("kafka的value: " + record.value().toString());
	}

	@KafkaListener(topics = { "ikangemployee" })
	public void listenee(ConsumerRecord<?, ?> record) {
		// MisEmployee misEmployee = JSON.parseObject(record.value().toString(), new
		// TypeReference<MisEmployee>() {
		// });
		logger.info("kafka的value: " + record.value().toString());
		logger.info("kafka的value数据:{} ", record.value().toString());
		MisEmployee misEmployee = JSON.parseObject(record.value().toString(), MisEmployee.class);
		setUser(misEmployee);
	}

	private int setUser(MisEmployee misEmployee) {
		User user = new User();
		logger.info("EHR用户转译前数据:{} ", JSON.toJSONString(misEmployee));
		convertUser(misEmployee, user);
		logger.info("EHR用户转译后数据:{} ", JSON.toJSONString(user));
		// 查看用户是否已经存在
		Integer userID = userMapper.selectByEhrUserId(user.getEhrUserId());
		int k = 0;
		if (StringUtils.isEmpty(userID)) {
			userMapper.insertSelective(user);
			k = insertUserOrgPermission(user.getOrgId(), user.getId());
		} else {
			k = userMapper.updateByPrimaryKey(user);
		}
		return k;
	}

	private void convertUser(MisEmployee misEmployee, User user) {
		user.setCreatedBy(0);
		user.setCreatedOn(new Date());
		user.setEhrUserId(misEmployee.getEhrId());
		user.setGender(misEmployee.getGender());
		user.setIdno(StringUtils.isEmpty(misEmployee.getIdCard()) ? "#########" : misEmployee.getIdCard());
		user.setLogonid(misEmployee.getEhrCode());
		user.setLogonPwd(misEmployee.getPassword());
		user.setMobile(StringUtils.isEmpty(misEmployee.getMobile()) ? "##########" : misEmployee.getMobile());
		user.setName(misEmployee.getName());
		user.setOrgId(Integer.valueOf(StringUtils.isEmpty(misEmployee.getCorp()) ? "1" : misEmployee.getCorp()));
		user.setStatus(0);
		user.setUpdatedBy(0);
		user.setUpdatedOn(new Date());
		user.setWorkno(misEmployee.getEhrCode());
	}

	private int insertUserOrgPermission(Integer orgId, Integer id) {
		// 获取其三级组织
		String express = orgHospMapper.selectOrgExpress(orgId);
		UserOrgPermission permissio = new UserOrgPermission();
		permissio.setCreatedBy(0);
		permissio.setCreatedOn(new Date());
		permissio.setExpress(express == null ? "0" : express);
		permissio.setOrgId(orgId);
		permissio.setStatus(0);
		permissio.setUpdatedBy(0);
		permissio.setUpdatedOn(new Date());
		permissio.setUserId(id);
		return userOrgPermissionMapper.insertSelective(permissio);
	}
}
