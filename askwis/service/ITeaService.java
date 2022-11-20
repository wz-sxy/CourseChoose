package com.askwis.service;

import com.askwis.domain.Tea;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ITeaService extends IService<Tea> {
    IPage<Tea> getPage(int currentPage, int pageSize);
    IPage<Tea> getPage(int currentPage, int pageSize,Tea tea);
}
