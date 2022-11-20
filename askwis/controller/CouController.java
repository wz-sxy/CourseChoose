package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Cou;
import com.askwis.service.ICouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Courses")
public class CouController {
    @Autowired
    private ICouService couBookService;

    @GetMapping
    public R getAll() {
        return new R(true, couBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Cou cou) {

        return new R(couBookService.save(cou));
    }

    @PutMapping
    public R update(@RequestBody Cou cou) {
        return new R(couBookService.updateById(cou));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {

        return new R(couBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {

        return new R(true, couBookService.getById(id));
    }
}
