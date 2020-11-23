package org.nr.tour.rpc;

import org.nr.tour.common.service.LineOrderServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(value = ServiceConstants.LINE_SERVICE, path = ServiceConstants.LINE_SERVICE_PATH_ORDER)
public interface LineOrderServiceClient extends LineOrderServiceDefinition {

}
