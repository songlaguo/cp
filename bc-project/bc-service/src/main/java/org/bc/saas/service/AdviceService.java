package org.bc.saas.service;

 
 
import org.bc.saas.persistence.AdviceMapper;
import org.bc.saas.vo.AdviceParam;
import org.bc.saas.vo.AdviceView;
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
