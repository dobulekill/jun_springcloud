package org.nr.tour.api.service;

import org.nr.tour.domain.PayTypeEnum;

/**
 * @author Wujun
 */
public interface OrderPayNotifyService {
    void success(String orderId, PayTypeEnum payTypeEnum) ;

    void fail(String merOrderId, PayTypeEnum quick);
}
