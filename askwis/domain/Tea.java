package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("teachers")
public class Tea {
    private Integer id;
    private String teaname;
    private Integer teaage;
    private String teagender;

}
