package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Teach;
import com.askwis.service.ITeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Teach")
public class TeachController {
    @Autowired
    private ITeachService teachBookService;

    @GetMapping
    public R getAll() {
        return new R(true,teachBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Teach teach) {
        return new R(teachBookService.save(teach));
    }

    @PutMapping
    public R update(@RequestBody Teach teach) {
        return new R(teachBookService.updateById(teach));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(teachBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true,teachBookService.getById(id));
    }

}
