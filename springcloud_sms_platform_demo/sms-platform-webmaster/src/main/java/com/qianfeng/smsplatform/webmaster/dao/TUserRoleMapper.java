package com.qianfeng.smsplatform.webmaster.dao;

import com.qianfeng.smsplatform.webmaster.pojo.TUserRoleExample;
import com.qianfeng.smsplatform.webmaster.pojo.TUserRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserRoleMapper {
    long countByExample(TUserRoleExample example);

    int deleteByExample(TUserRoleExample example);

    int deleteByPrimaryKey(TUserRoleKey key);

    int insert(TUserRoleKey record);

    int insertSelective(TUserRoleKey record);

    List<TUserRoleKey> selectByExample(TUserRoleExample example);

    int updateByExampleSelective(@Param("record") TUserRoleKey record, @Param("example") TUserRoleExample example);

    int updateByExample(@Param("record") TUserRoleKey record, @Param("example") TUserRoleExample example);
}