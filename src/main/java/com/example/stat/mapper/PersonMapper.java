package com.example.stat.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.stat.entity.Person;
import com.example.stat.vo.PieVO;
import java.util.List;

public interface PersonMapper extends BaseMapper<Person> {
    public List<PieVO> findAll();
}
