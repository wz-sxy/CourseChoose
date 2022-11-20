package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("classes")
public class Cla {
    private Integer id;
    private String claname;
}
