package org.nr.tour.service;

import org.nr.tour.BaseService;
import org.nr.tour.domain.Ticket;
import org.nr.tour.domain.TicketOrder;

import java.util.List;

/**
 * @author Wujun
 */
public interface TicketService extends BaseService<Ticket> {
    List<Ticket> getBySceneryId(String sceneryId);
}
