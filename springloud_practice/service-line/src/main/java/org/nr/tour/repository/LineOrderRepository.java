package org.nr.tour.repository;

import org.nr.tour.BaseOrderRepository;
import org.nr.tour.domain.LineOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface LineOrderRepository extends BaseOrderRepository<LineOrder> {
}
