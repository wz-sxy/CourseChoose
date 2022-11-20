package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("teach")
public class Teach {
    private Integer id;
    private Integer teaid;
    private Integer couid;
}
