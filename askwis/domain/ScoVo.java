package com.askwis.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("scores")
public class ScoVo {
    @ExcelProperty("学生姓名")
    private String stuname;
    @ExcelProperty("教师姓名")
    private String teaname;
    @ExcelProperty("课程")
    private String course;
    @ExcelProperty("班级")
    private String claname;
    @ExcelProperty("得分")
    private Integer score;
}
