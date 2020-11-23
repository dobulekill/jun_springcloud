package org.nr.tour.repository;

import org.nr.tour.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface DictRepository extends JpaRepository<Dict, String> {
    List<Dict> findByTypeOrderBySortAsc(String type);
}
