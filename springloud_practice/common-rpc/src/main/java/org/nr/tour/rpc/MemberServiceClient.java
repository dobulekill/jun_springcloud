package org.nr.tour.rpc;

import org.nr.tour.common.service.MemberServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(value = ServiceConstants.MEMBER_SERVICE)
public interface MemberServiceClient extends MemberServiceDefinition {

}
