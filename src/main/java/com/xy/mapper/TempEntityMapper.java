package com.xy.mapper;

import com.xy.entity.TempEntity;

import java.util.List;

public interface TempEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempEntity record);

    int insertSelective(TempEntity record);

    TempEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempEntity record);

    int updateByPrimaryKey(TempEntity record);

    List<TempEntity> selectAll();

    Integer selectCount();
}