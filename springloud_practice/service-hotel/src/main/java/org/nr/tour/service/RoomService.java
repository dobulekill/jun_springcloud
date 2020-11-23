package org.nr.tour.service;

import org.nr.tour.BaseService;
import org.nr.tour.domain.Room;

import java.util.List;

/**
 * @author Wujun
 */
public interface RoomService extends BaseService<Room> {
    List<Room> getByHotelId(String hotelId);
}
