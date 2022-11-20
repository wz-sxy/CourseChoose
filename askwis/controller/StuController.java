package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Stu;
import com.askwis.service.IStuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Students")
public class StuController {
    @Autowired
    private IStuService stuBookService;

    @GetMapping
    public R getAll() {
        return new R(true, stuBookService.list());
    }

    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "StudentName",value = "姓名",required = true,paramType
                    = "query"),
            @ApiImplicitParam(name = "StudentAge",value = "年龄",required = true,paramType =
                    "query",dataType = "Integer"),
            @ApiImplicitParam(name = "StudentGender",value = "性别",required = true,paramType =
                    "query"),
            @ApiImplicitParam(name = "grade",value = "年级",required = true,paramType =
                    "query"),
            @ApiImplicitParam(name = "claid",value = "班级",required = true,paramType =
                    "query",dataType = "Integer")
    })
    public R save(@RequestBody Stu stu) {
        return new R(stuBookService.save(stu));
    }

    @PutMapping
    public R update(@RequestBody Stu stu) {
        return new R(stuBookService.updateById(stu));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(stuBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, stuBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Stu stu) {

        IPage<Stu> page = stuBookService.getPage(currentPage, pageSize,stu);
        //如果页码超过最大，则执行最大
        if (currentPage > page.getPages()) {
            page = stuBookService.getPage((int) page.getPages(), pageSize,stu);
        }
        return new R(true, page);
    }
}
