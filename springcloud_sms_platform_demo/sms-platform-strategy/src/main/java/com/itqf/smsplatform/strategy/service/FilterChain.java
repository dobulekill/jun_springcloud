package com.itqf.smsplatform.strategy.service;

import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.exception.DataProcessException;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:19
 * description:
 */


public interface FilterChain {
    /**
     * @param submit 代表要被处理的数据对象
     * @return
     * @throws DataProcessException 我们预估这里面肯定会出现异常,如果出现异常的话,我们需要转换成自定义的异常来处理
     */
    boolean dealSms(Standard_Submit submit) throws DataProcessException;
}
