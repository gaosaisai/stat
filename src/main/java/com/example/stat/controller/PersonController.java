package com.example.stat.controller;

import com.example.stat.service.PersonService;
import com.example.stat.vo.DataVO;
import com.example.stat.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(
            Integer page,
            Integer limit,
            Integer min_year,
            Integer max_year,
            Integer min_travelkm,
            Integer max_travelkm,
            Integer min_traveltime,
            Integer max_traveltime
    ){
        return personService.findData(page,limit,min_year,max_year,min_travelkm,max_travelkm,min_traveltime,max_traveltime);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/pieVO")
    @ResponseBody
    public PieVO list(
            Integer min_year,Integer max_year
    ){
        return personService.getPieVO(min_year,max_year);
    }
}
