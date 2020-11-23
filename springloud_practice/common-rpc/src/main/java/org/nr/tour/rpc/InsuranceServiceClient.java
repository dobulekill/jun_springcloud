package org.nr.tour.rpc;

import org.nr.tour.common.service.AbstractServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.nr.tour.domain.Insurance;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(value = ServiceConstants.LINE_SERVICE, path = ServiceConstants.LINE_SERVICE_PATH_INSURANCE)
public interface InsuranceServiceClient extends AbstractServiceDefinition<Insurance, String> {

}
