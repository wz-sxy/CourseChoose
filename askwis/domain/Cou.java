package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("courses")
public class Cou {
    private Integer id;
    private String course;
}
