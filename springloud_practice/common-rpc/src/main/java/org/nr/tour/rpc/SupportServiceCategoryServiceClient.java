package org.nr.tour.rpc;

import org.nr.tour.common.service.AbstractServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.nr.tour.domain.SupportServiceCategory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(value = ServiceConstants.HOTEL_SERVICE, path = ServiceConstants.PATH_SERVICE_CATEGORY)
public interface SupportServiceCategoryServiceClient extends AbstractServiceDefinition<SupportServiceCategory, String> {

}
