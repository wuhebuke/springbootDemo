package com.company.springbootDemo.entity.zoning;

import lombok.Data;

import java.util.List;

/**
 * @author : farid
 * @date : 2023/6/3
 */
@Data
public class Province {
    private String code;
    private String name;
    private List<City> cities;
}
