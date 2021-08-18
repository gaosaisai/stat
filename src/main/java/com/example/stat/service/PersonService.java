package com.example.stat.service;

import com.example.stat.vo.DataVO;
import com.example.stat.vo.PersonVO;
import com.example.stat.vo.PieVO;
import java.util.List;

public interface PersonService {
    public DataVO<PersonVO> findData(Integer page,Integer limit,Integer min_year,Integer max_year,Integer min_travelkm,Integer max_travelkm,Integer min_traveltime,Integer max_traveltime);
    public PieVO<PersonVO> getPieVO(Integer min_year,Integer max_year);
}
