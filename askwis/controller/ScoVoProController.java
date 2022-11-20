package com.askwis.controller;

import com.askwis.domain.ScoVo;
import com.askwis.service.IScoVoProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/ScoreShow")
public class ScoVoProController {

    @Autowired
    private IScoVoProService iScoVoProService;
    @GetMapping
    public List<OptionalDouble> getScoVo1(){
        ScoVo scoVo2 = new ScoVo();
        scoVo2.setClaname("一班");
        ScoVo scoVo3 = new ScoVo();
        scoVo3.setClaname("二班");
        ScoVo scoVo4 = new ScoVo();
        scoVo4.setClaname("三班");
        ScoVo scoVo5 = new ScoVo();
        scoVo5.setClaname("四班");
        ScoVo scoVo6 = new ScoVo();
        scoVo6.setClaname("五班");
        List<OptionalDouble> avg = new ArrayList<>();
        List<ScoVo> scoVo7 = iScoVoProService.getScoVo1(scoVo2);
        avg.add(scoVo7.stream().mapToInt(ScoVo::getScore).average());
        List<ScoVo> scoVo8 = iScoVoProService.getScoVo1(scoVo3);
        avg.add(scoVo8.stream().mapToInt(ScoVo::getScore).average());
        List<ScoVo> scoVo9 = iScoVoProService.getScoVo1(scoVo4);
        avg.add(scoVo9.stream().mapToInt(ScoVo::getScore).average());
        List<ScoVo> scoVo10 = iScoVoProService.getScoVo1(scoVo5);
        System.out.println("ok");
//        第二代
        avg.add(scoVo10.stream().mapToInt(ScoVo::getScore).average());
        List<ScoVo> scoVo11 = iScoVoProService.getScoVo1(scoVo6);
        avg.add(scoVo11.stream().mapToInt(ScoVo::getScore).average());
        System.out.println(avg);
        return avg;
    }

}
