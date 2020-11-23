package com.opencloud.msg.mapper;

import com.opencloud.common.mybatis.base.mapper.SuperMapper;
import com.opencloud.msg.client.model.entity.WebhookLogs;
import org.springframework.stereotype.Repository;

/**
 * @author Wujun
 */
@Repository
public interface WebhookLogsMapper extends SuperMapper<WebhookLogs> {
}
