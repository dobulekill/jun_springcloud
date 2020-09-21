package com.itqf.smsplatform.strategy.service.impl;

import com.itqf.smsplatform.common.model.Standard_Submit;
import com.itqf.smsplatform.strategy.exception.DataProcessException;
import com.itqf.smsplatform.strategy.service.FilterChain;
import org.springframework.stereotype.Service;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:32
 * description:
 */

@Service
public class SmsOpIDFilter implements FilterChain {
    @Override
    public boolean dealSms(Standard_Submit submit) throws DataProcessException {
        return false;
    }
}
