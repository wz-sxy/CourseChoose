package com.askwis.service;

import com.alibaba.excel.EasyExcel;
import com.askwis.domain.ScoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IScoVoProService extends IService<ScoVo> {
    List<ScoVo> getScoVo1(ScoVo scoVo);
    void poiImport(List list, String xlsPath, String xlsName, String... titles);
}
