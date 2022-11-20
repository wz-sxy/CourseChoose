package com.askwis.service.impl;

import com.askwis.dao.ScoDao;
import com.askwis.domain.Sco;
import com.askwis.domain.Stu;
import com.askwis.service.IScoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoServiceImpl extends ServiceImpl<ScoDao, Sco> implements IScoService {
    @Autowired
    private ScoDao scoDao;
}
