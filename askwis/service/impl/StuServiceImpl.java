package com.askwis.service.impl;

import com.askwis.dao.StuDao;
import com.askwis.domain.Stu;
import com.askwis.service.IStuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl extends ServiceImpl<StuDao, Stu> implements IStuService {

    @Autowired
    private StuDao stuDao;

    @Override
    public IPage<Stu> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        stuDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Stu> getPage(int currentPage, int pageSize, Stu stu) {

        LambdaQueryWrapper<Stu> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(stu.getStuname()),Stu::getStuname,stu.getStuname());
        lqw.like(stu.getStuage()!=null,Stu::getStuage,stu.getStuage());
        lqw.like(Strings.isNotEmpty(stu.getStugender()),Stu::getStugender,stu.getStugender());
        lqw.like(Strings.isNotEmpty(stu.getGrade()),Stu::getGrade,stu.getGrade());
        lqw.like(stu.getClaid()!=null,Stu::getClaid,stu.getClaid());

        IPage page = new Page(currentPage, pageSize);
        stuDao.selectPage(page, lqw);
        return page;
    }
}
