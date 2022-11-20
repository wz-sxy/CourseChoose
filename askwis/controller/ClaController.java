package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Cla;
import com.askwis.service.IClaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Classes")
public class ClaController {
    @Autowired
    private IClaService claBookService;

    @GetMapping
    public R getAll() {
        return new R(true, claBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Cla cla) {

        return new R(claBookService.save(cla));
    }

    @PutMapping
    public R update(@RequestBody Cla cla) {
        return new R(claBookService.updateById(cla));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(claBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, claBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true, claBookService.getPage(currentPage, pageSize));
    }
}

