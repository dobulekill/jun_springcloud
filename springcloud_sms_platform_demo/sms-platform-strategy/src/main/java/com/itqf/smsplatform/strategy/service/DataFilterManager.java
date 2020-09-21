package com.itqf.smsplatform.strategy.service;

import com.itqf.smsplatform.common.model.Standard_Submit;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:24
 * description:
 */


public interface DataFilterManager {
    /**
     * 处理我们的消息,按照我们的项目要求,在这个实现中我们需要找到它需要经过的所有的过滤器,挨着调用
     *
     * @param submit
     */
    void dealSms(Standard_Submit submit);
}
