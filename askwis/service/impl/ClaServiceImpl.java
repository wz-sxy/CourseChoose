package com.askwis.service.impl;

import com.askwis.dao.ClaDao;
import com.askwis.domain.Cla;
import com.askwis.service.IClaService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaServiceImpl extends ServiceImpl<ClaDao, Cla> implements IClaService {

    @Autowired
    private ClaDao claDao;
    @Override
    public IPage<Cla> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        claDao.selectPage(page,null);
        return page;
    }
}
