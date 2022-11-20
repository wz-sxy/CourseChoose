package com.askwis.dao;

import com.askwis.domain.Tea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeaDao extends BaseMapper<Tea> {
}

