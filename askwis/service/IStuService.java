package com.askwis.service;


import com.askwis.domain.Stu;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IStuService extends IService<Stu> {
    IPage<Stu> getPage(int currentPage, int pageSize);
    IPage<Stu> getPage(int currentPage, int pageSize,Stu stu);

}
