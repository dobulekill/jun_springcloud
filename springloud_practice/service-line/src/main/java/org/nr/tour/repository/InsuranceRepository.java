package org.nr.tour.repository;

import org.nr.tour.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
}
