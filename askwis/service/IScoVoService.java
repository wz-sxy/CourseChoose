package com.askwis.service;

import com.askwis.domain.ScoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IScoVoService extends IService<ScoVo> {
    List<ScoVo> getScoVo(ScoVo scoVo);
}
