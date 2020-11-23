package org.nr.tour.repository;

import org.nr.tour.domain.StorageObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface StorageObjectRepository extends JpaRepository<StorageObject, String> {
}
