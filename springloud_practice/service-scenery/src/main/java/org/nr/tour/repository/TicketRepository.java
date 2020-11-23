package org.nr.tour.repository;

import org.nr.tour.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findBySceneryId(String sceneryId);
}
