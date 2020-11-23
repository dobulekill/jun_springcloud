package org.nr.tour.rpc;

import org.nr.tour.common.service.VerifyCodeServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(ServiceConstants.VERIFY_CODE_SERVICE)
public interface VerifyCodeServiceClient extends VerifyCodeServiceDefinition {

}
