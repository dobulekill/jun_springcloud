package org.nr.tour.common.service;

import org.nr.tour.domain.HotelSupportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Wujun
 */
public interface HotelSupportServiceDefinition {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestParam("hotelId") String hotelId, @RequestParam("serviceIds") List<String> serviceIds);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    List<HotelSupportService> getById(@RequestParam("hotelId") String hotelId);
}
