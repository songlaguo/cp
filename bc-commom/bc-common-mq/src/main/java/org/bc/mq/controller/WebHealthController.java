package org.bc.mq.controller;

import org.bc.common.annotation.NoNeedToLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

 

import io.swagger.annotations.ApiOperation;

/**
 * 功能概述：验证web服务及数据库健康状况
 */
@Controller
@RequestMapping("/check")
public class WebHealthController {
	@NoNeedToLogin
	@RequestMapping(value = "/alive", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "站点健康检查（web）", notes = "检测web节点是否健康，返回success健康", tags = "v1.0.0")
	public String checkWeb() {
		return "success";
	}
}
