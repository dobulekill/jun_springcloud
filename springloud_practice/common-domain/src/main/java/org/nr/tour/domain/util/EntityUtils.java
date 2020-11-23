package org.nr.tour.domain.util;

import org.nr.tour.domain.IDEntity;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author Wujun
 */
public class EntityUtils {

    public static void preSave(IDEntity entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
    }
}
