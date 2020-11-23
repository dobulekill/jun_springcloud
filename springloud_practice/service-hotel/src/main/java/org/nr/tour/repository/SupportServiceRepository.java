package org.nr.tour.repository;

import org.nr.tour.domain.SupportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface SupportServiceRepository extends JpaRepository<SupportService, String> {
}
