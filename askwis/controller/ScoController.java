package com.askwis.controller;//package com.askwis.controller;

import com.askwis.controller.utils.R;
import com.askwis.domain.Sco;
import com.askwis.domain.Stu;
import com.askwis.service.IScoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Scores")
public class ScoController {
    @Autowired
    private IScoService iScoService;

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, iScoService.getById(id));
    }


    @PostMapping
    public R save(@RequestBody Sco sco) {
        return new R(iScoService.save(sco), sco);
    }

    @PutMapping
    public R update(@RequestBody Sco sco) {
        return new R(iScoService.updateById(sco));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(iScoService.removeById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Sco sco) {
//
//        IPage<Sco> page = iScoService.getPage(currentPage, pageSize,sco);
//        //如果页码超过最大，则执行最大
//        if (currentPage > page.getPages()) {
//            page = iScoService.getPage((int) page.getPages(), pageSize,sco);
//        }
//        return new R(true, page);
//    }
}
