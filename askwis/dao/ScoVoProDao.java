package com.askwis.dao;

import com.askwis.domain.ScoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoVoProDao extends BaseMapper<ScoVo> {
    @Select("SELECT students.`stuname`,teachers.`teaname`,courses.course,classes.`claname`,scores.score " +
            "FROM scores " +
            "INNER JOIN students ON stuid=students.id " +
            "INNER JOIN teach ON teachid=teach.id " +
            "INNER JOIN teachers ON teaid=teachers.id " +
            "INNER JOIN courses ON couid=courses.id " +
            "INNER JOIN classes ON claid=classes.id " +
            "WHERE ( classes.claname=#{claname} or #{claname}='')"
    )
    List<ScoVo> getScoVo1(ScoVo scoVo);
}
