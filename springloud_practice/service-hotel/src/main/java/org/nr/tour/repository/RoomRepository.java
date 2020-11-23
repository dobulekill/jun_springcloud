package org.nr.tour.repository;

import org.nr.tour.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> getByHotelId(String hotelId);
}
