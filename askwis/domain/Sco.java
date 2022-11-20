package com.askwis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("scores")
public class Sco {
    private Integer id;
    private Integer score;
    private String date;
    private Integer stuid;
    private Integer teachid;
}
