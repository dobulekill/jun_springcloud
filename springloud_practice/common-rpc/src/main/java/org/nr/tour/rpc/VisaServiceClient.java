package org.nr.tour.rpc;

import org.nr.tour.common.service.AbstractServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.nr.tour.domain.Visa;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(ServiceConstants.VISA_SERVICE)
public interface VisaServiceClient extends AbstractServiceDefinition<Visa, String> {

}
