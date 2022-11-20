package com.askwis.service.impl;

import com.askwis.dao.ScoVoDao;
import com.askwis.domain.ScoVo;
import com.askwis.service.IScoVoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoVoServiceImpl extends ServiceImpl<ScoVoDao, ScoVo> implements IScoVoService {
    @Autowired
    private ScoVoDao scoVoDao;

    @Override
    public List<ScoVo> getScoVo(ScoVo scoVo){
        return scoVoDao.getScoVo(scoVo);
    }
}
