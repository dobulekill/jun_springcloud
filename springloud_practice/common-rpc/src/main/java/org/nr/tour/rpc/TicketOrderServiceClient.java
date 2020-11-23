package org.nr.tour.rpc;

import org.nr.tour.common.service.TicketOrderServiceDefinition;
import org.nr.tour.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Wujun
 */
@FeignClient(value = ServiceConstants.SCENERY_SERVICE, path = ServiceConstants.SCENERY_SERVICE_PATH_TICKET_ORDER)
public interface TicketOrderServiceClient extends TicketOrderServiceDefinition {

}
