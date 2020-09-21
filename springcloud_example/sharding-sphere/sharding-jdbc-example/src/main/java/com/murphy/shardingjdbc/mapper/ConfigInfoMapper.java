package com.murphy.shardingjdbc.mapper;

import com.murphy.shardingjdbc.module.ConfigInfo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author dongsufeng
 * @date 2019/12/5 16:29
 * @version 1.0
 */
@Mapper
public interface ConfigInfoMapper extends tk.mybatis.mapper.common.Mapper<ConfigInfo>, MySqlMapper<ConfigInfo> {
}
