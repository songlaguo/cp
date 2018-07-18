package org.bc.service;

 
import com.ikang.saas.common.interceptor.PageInterceptor;
import com.ikang.saas.common.vo.Page;

import org.bc.persistence.AdviceMapper;
import org.bc.vo.AdviceParam;
import org.bc.vo.AdviceView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议service
 * @author gjf
 * @create 2018/6/21.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdviceService {
    @Autowired
    private AdviceMapper adviceMapper;
 
    /**
     * 分页列表
     * @param adviceParam
     * @return
     */
 

    /**
     * 建议详情
     * @param id
     * @return
     */
 

}
