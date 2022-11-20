package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("students")
public class Stu {
    private Integer id;
    private String stuname;
    private Integer stuage;
    private String stugender;
    private String grade;
    private Integer claid;

}
