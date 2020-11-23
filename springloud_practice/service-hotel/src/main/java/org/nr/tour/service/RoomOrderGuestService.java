package org.nr.tour.service;

import org.nr.tour.BaseService;
import org.nr.tour.domain.RoomOrderGuest;

import java.util.List;

/**
 * @author Wujun
 */
public interface RoomOrderGuestService extends BaseService<RoomOrderGuest> {
    List<RoomOrderGuest> findByRoomOrderId(String orderId);
}
