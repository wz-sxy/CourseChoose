package com.askwis.service;

import com.askwis.domain.Cla;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IClaService extends IService<Cla> {
    IPage<Cla> getPage(int currentPage, int pageSize);
}
