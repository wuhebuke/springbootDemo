package com.company.springbootDemo.service;

import com.company.springbootDemo.dao.ZoningMapper;
import com.company.springbootDemo.entity.zoning.City;
import com.company.springbootDemo.entity.zoning.County;
import com.company.springbootDemo.entity.zoning.Province;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : farid
 * @date : 2023/6/3
 */
@Service
public class ZoningService {
    @Resource
    private ZoningMapper zoningMapper;

    public List<Province> queryZoning(){
        List<Province> provinces = zoningMapper.queryProvince();
        for (Province province : provinces) {
            String provinceCode = province.getCode().substring(0, 2);
            List<City> cityList = zoningMapper.queryCityByProvince(provinceCode);
            province.setCities(cityList);
            for (City city : cityList) {
                String cityCode = city.getCode().substring(0, 4);
                List<County> counties = zoningMapper.queryCountyByCity(cityCode);
                city.setCounties(counties);
            }
        }
        return provinces;
    }
}
