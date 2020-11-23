package org.nr.tour.common.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Wujun
 */
@Service
public class IdServiceUUIDImpl implements IdService {

    @Override
    public String newOne() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
