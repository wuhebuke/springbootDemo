package com.company.springbootDemo.controller;

import com.company.springbootDemo.entity.zoning.Province;
import com.company.springbootDemo.service.ZoningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : farid
 * @date : 2023/6/3
 */
@RestController
@RequestMapping("/zoning")
public class ZoningController {
    @Resource
    private ZoningService zoningService;

    @GetMapping("/queryZoning")
    public List<Province> queryZoning(){
        return zoningService.queryZoning();
    }
}
