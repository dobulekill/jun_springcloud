package org.nr.tour.repository;

import org.nr.tour.BaseOrderRepository;
import org.nr.tour.domain.TicketOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface TicketOrderRepository extends BaseOrderRepository<TicketOrder> {
}
