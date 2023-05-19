package com.company.springbootDemo.entity;

import lombok.Data;

/**
 * @author : farid
 * @date : 2023/4/25 19:21
 */
@Data
public class Person {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private Integer score;
    private String province;
    private String city;
    private String district;
}
