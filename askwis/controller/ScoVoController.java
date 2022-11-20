package com.askwis.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.askwis.controller.utils.DownExecl;
import com.askwis.controller.utils.R;
import com.askwis.domain.ScoVo;
import com.askwis.service.IScoVoProService;
import com.askwis.service.IScoVoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Score")
public class ScoVoController {
    @Autowired
    private IScoVoService iScoVoService;
    @Autowired
    private IScoVoProService iScoVoProService;

    @GetMapping("{currentPage}/{pageSize}")
    public R getScoVo(@PathVariable int currentPage, @PathVariable int pageSize,ScoVo scoVo){
        List<ScoVo> scoVo1 = iScoVoService.getScoVo(scoVo);
        List pageList = new ArrayList<>();
        int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;
        for (int i = 0; i < pageSize && curIdx + i < scoVo1.size(); i++) {
            pageList.add(scoVo1.get(curIdx + i));
        }
        IPage page = new Page<>(currentPage, pageSize);
        page.setRecords(pageList);
        page.setTotal(scoVo1.size());
        return new R(true, page);
    }


    @GetMapping("/To/{currentPage}/{pageSize}")
    public void ToExecl(@PathVariable int currentPage, @PathVariable int pageSize, ScoVo scoVo,HttpServletResponse response)throws IOException
            {
        List<ScoVo> scoVo1 = iScoVoService.getScoVo(scoVo);
        List pageList = new ArrayList<>();
        int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;
        for (int i = 0; i < pageSize && curIdx + i < scoVo1.size(); i++) {
            pageList.add(scoVo1.get(curIdx + i));
        }
        IPage page = new Page<>(currentPage, pageSize);
        page.setRecords(pageList);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ScoVo.class).sheet("模板").doWrite(pageList);
    }
//        iScoVoProService.poiImport(pageList,"D:\\Desk\\msg.xls","成绩表","学生姓名","教师姓名","课程",
//                "班级","得分");





}
