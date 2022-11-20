package com.askwis.service.impl;

import com.askwis.dao.TeaDao;
import com.askwis.domain.Tea;
import com.askwis.service.ITeaService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaServiceImpl extends ServiceImpl<TeaDao, Tea> implements ITeaService {

    @Autowired
    private TeaDao teaDao;
    @Override
    public IPage<Tea> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        teaDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Tea> getPage(int currentPage, int pageSize, Tea tea) {

        LambdaQueryWrapper<Tea> lqw = new LambdaQueryWrapper<Tea>();
        lqw.like(Strings.isNotEmpty(tea.getTeaname()),Tea::getTeaname,tea.getTeaname());
        lqw.like(tea.getTeaage()!=null,Tea::getTeaage,tea.getTeaage());
        lqw.like(Strings.isNotEmpty(tea.getTeagender()),Tea::getTeagender,tea.getTeagender());

        IPage page = new Page(currentPage, pageSize);
        teaDao.selectPage(page, lqw);
        return page;
    }
}
