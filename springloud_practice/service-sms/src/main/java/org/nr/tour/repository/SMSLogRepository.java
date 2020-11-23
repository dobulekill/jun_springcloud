package org.nr.tour.repository;

import org.nr.tour.domain.SMSLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface SMSLogRepository extends JpaRepository<SMSLog, String> {
}
