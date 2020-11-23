package com.murphy.shardingjdbc.mapper;

import com.murphy.shardingjdbc.module.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author Wujun
 * @date 2019/12/5 16:29
 * @version 1.0
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>, MySqlMapper<User> {
}
