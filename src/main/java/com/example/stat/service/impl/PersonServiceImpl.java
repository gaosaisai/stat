package com.example.stat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stat.entity.Person;
import com.example.stat.mapper.PersonMapper;
import com.example.stat.service.PersonService;
import com.example.stat.vo.DataVO;
import com.example.stat.vo.PieVO;
import com.example.stat.vo.PersonVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public DataVO<PersonVO> findData(
            Integer page,
            Integer limit,
            Integer min_year,
            Integer max_year,
            Integer min_travelkm,
            Integer max_travelkm,
            Integer min_traveltime,
            Integer max_traveltime
    ) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        IPage<Person> personIPage = new Page<>(page,limit);
        QueryWrapper<Person> qw = new QueryWrapper<>();
        if (min_year != null){
            qw.ge("birth",min_year);//这里加的是表中的字段名称,ge 大于等于
        }
        if (max_year != null){
            qw.le("birth",max_year);//le 小于等于
        }
        if (min_travelkm != null){
            qw.ge("travelkm",min_travelkm);//这里加的是表中的字段名称,ge 大于等于
        }
        if (max_travelkm != null){
            qw.le("travelkm",max_travelkm);//le 小于等于
        }
        if (min_traveltime != null){
            qw.ge("traveltime",min_traveltime);//这里加的是表中的字段名称,ge 大于等于
        }
        if (max_traveltime != null){
            qw.le("traveltime",max_traveltime);//le 小于等于
        }
        IPage<Person> pageResult = personMapper.selectPage(personIPage,qw);
        dataVO.setCount(pageResult.getTotal());
        List<Person> personList = pageResult.getRecords();
        List<PersonVO> personVOList = new ArrayList<>();
        for (Person person : personList){
            PersonVO personVO = new PersonVO();
            BeanUtils.copyProperties(person,personVO);
            personVOList.add(personVO);
        }
        dataVO.setData(personList);
        return dataVO;
    }

    @Override
    public PieVO<PersonVO> getPieVO( Integer min_year, Integer max_year) {
        PieVO pieVO = new PieVO();
        QueryWrapper<Person> qw = new QueryWrapper<>();
        if (min_year != null){
            qw.ge("birth",min_year);//这里加的是表中的字段名称,ge 大于等于
        }
        if (max_year != null){
            qw.le("birth",max_year);//le 小于等于
        }
        List<Person> personList = personMapper.selectList(qw);
        List<PersonVO> personVOList = new ArrayList<>();
        for (Person person : personList){
            PersonVO personVO = new PersonVO();
            BeanUtils.copyProperties(person,personVO);
            personVOList.add(personVO);
        }
        pieVO.setData(personVOList);
        return pieVO;
    }
}
