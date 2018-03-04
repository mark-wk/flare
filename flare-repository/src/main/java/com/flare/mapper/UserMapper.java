package com.flare.mapper;

import com.flare.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long testId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long testId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}