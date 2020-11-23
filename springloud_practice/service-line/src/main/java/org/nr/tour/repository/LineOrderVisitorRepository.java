package org.nr.tour.repository;

import org.nr.tour.domain.LineOrderVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface LineOrderVisitorRepository extends JpaRepository<LineOrderVisitor, String> {
    List<LineOrderVisitor> findByOrderId(String lineOrderId);
}
