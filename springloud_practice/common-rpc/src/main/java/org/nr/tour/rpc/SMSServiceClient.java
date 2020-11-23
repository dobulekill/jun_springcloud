package org.nr.tour.rpc;

import org.nr.tour.common.service.SMSServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(ServiceConstants.SMS_SERVICE)
public interface SMSServiceClient extends SMSServiceDefinition {

}
