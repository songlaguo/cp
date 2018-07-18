package junit.service;

import org.bc.common.entity.User;
import org.bc.mq.persistence.OrgHospMapper;
import org.bc.mq.persistence.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

 

import junit.BaseJUnit;

/**
 * @author : R&M www.rmworking.com/blog 2018/5/16 15:03 saas-rbac-parent junit.service
 */
public class UserJUnit extends BaseJUnit {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrgHospMapper orgHospMapper;

	@Test
	public void insert() {
		User record = new User();
		record.setLogonid("12398798798791");
		record.setLogonPwd("123456");
		record.setName("测试用户123");
		record.setIdno("123456789000");
		record.setMobile("12311111111");
		record.setStatus(0);
		record.setOrgId(1002);
		int result = userMapper.insertSelective(record);
		System.out.println(record.getId());
	}

	@Test
	public void select() {
		Integer userID = userMapper.selectByEhrUserId("1040H6100000000000V2");
		System.out.println(userID);
	}

	@Test
	public void selectExpree() {
		String str = orgHospMapper.selectOrgExpress(1124);
		System.out.println(str);
	}
}
