package org.bc.web.controller;

import org.bc.service.AdviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

/**

 * @ClassName: SampleTypeController

 * @Description:   样本类型-->操作类

 * @author: sqz

 * @date: 2018年6月21日 上午11:41:16

/**



 

 * @Description: 

 * @author: js

 * @date: 2018年6月21日 上午11:41:58


 */
@CrossOrigin()
@RestController
@RequestMapping(value = "/v1/sampletypes")
public class SampleTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleTypeController.class);
	@Autowired
	private final AdviceService adviceService;
	public SampleTypeController(AdviceService adviceService) {
		 this.adviceService=adviceService;
	}
 
	/**
	
	 * @Title: getSampleTypes
	
	 * @Description:  分页获取--》样本类型列表 
	
	 * @param request
	 * @param querySampleType   {name:可为空}
	 * @return
	
	 * @return: AppResult<Page>
	
	 */

	
	
	/**
	 * @Title: getSampleType
	 * @Description:  根据id查询 --》样本类型
	 * @param request
	 * @param id 不可为空
	 * @return
	 * @return: AppResult<SampleTypeView.GetSampleType>
	 */
  

 
	/**
	
	 * @Title: getSampleTypes
	
	 * @Description:  分页获取--》样本类型列表  不分页 状态为启用
	
	 * @param request
 
	 * @return
	
	 * @return: AppResult<Page>
	
	 */


 
 
	
}
