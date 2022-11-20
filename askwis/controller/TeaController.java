package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Stu;
import com.askwis.domain.Tea;
import com.askwis.service.ITeaService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Teachers")
public class TeaController {
    @Autowired
    private ITeaService teaBookService;

    @GetMapping
    public R getAll() {
        return new R(true, teaBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Tea tea) {
        return new R(teaBookService.save(tea));
    }

    @PutMapping
    public R update(@RequestBody Tea tea) {
        teaBookService.updateById(tea);
        return new R(teaBookService.updateById(tea));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(teaBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, teaBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Tea tea) {
        IPage<Tea> page = teaBookService.getPage(currentPage, pageSize,tea);
        //如果页码超过最大，则执行最大
        if (currentPage > page.getPages()) {
            page = teaBookService.getPage((int) page.getPages(), pageSize,tea);
        }
        return new R(true, page);
    }
}
