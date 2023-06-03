package com.company.springbootDemo.dao;

import com.company.springbootDemo.entity.zoning.City;
import com.company.springbootDemo.entity.zoning.County;
import com.company.springbootDemo.entity.zoning.Province;

import java.util.List;

/**
 * @author : farid
 * @date : 2023/6/3 15:12
 */
public interface ZoningMapper {
    List<County> queryCounty();

    List<City> queryCity();

    List<Province> queryProvince();

    List<City> queryCityByProvince(String value);

    List<County> queryCountyByCity(String value);

}
