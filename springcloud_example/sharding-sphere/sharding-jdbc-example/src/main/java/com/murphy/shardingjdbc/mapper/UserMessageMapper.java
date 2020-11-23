package com.murphy.shardingjdbc.mapper;

import com.murphy.shardingjdbc.module.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author Wujun
 * @date 2019/12/5 16:29
 * @version 1.0
 */
@Mapper
public interface UserMessageMapper extends tk.mybatis.mapper.common.Mapper<UserMessage>, MySqlMapper<UserMessage> {
}
