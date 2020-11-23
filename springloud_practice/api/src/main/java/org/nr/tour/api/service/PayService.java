package org.nr.tour.api.service;

import org.nr.tour.api.service.impl.PayStatusEnum;

/**
 * @author Wujun
 */
public interface PayService {

    String getPayString(String orderId, Double price);

    void updateOrderStatus(String orderId);

}
