package org.nr.tour.repository;

import org.nr.tour.domain.TicketOrderVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface TicketOrderVisitorRepository extends JpaRepository<TicketOrderVisitor, String> {
    List<TicketOrderVisitor> findByOrderId(String lineOrderId);
}
