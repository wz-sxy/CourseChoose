package com.askwis.dao;

import com.askwis.domain.ScoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoVoDao extends BaseMapper<ScoVo> {
    @Select("SELECT students.`stuname`,teachers.`teaname`,courses.course,classes.`claname`,scores.score " +
            "FROM scores " +
            "INNER JOIN students ON stuid=students.id " +
            "INNER JOIN teach ON teachid=teach.id " +
            "INNER JOIN teachers ON teaid=teachers.id " +
            "INNER JOIN courses ON couid=courses.id " +
            "INNER JOIN classes ON claid=classes.id " +
            "WHERE (students.stuname=#{stuname} or #{stuname}='')" +
            "AND( teachers.teaname=#{teaname} or #{teaname}='')"+
            "AND( courses.course=#{course} or #{course}='')" +
            "AND( classes.claname=#{claname} or #{claname}='')" +
            "AND( scores.score=#{score} or #{score} is null)"
    )
    List<ScoVo> getScoVo(ScoVo scoVo);


}
