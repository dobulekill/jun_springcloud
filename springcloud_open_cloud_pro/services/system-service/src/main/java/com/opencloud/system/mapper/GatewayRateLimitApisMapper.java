package com.opencloud.system.mapper;

import com.opencloud.system.client.model.RateLimitApi;
import com.opencloud.common.mybatis.base.mapper.SuperMapper;
import com.opencloud.system.client.model.entity.GatewayRateLimitApi;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wujun
 */
@Repository
public interface GatewayRateLimitApisMapper extends SuperMapper<GatewayRateLimitApi> {

    List<RateLimitApi> selectRateLimitApi();

}
