package com.company.springbootDemo.controller;

import com.company.springbootDemo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : farid
 * @date : 2023/4/25 19:22
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @PostMapping("/insertPersonRole")
    public int insertPersonRole(Integer[] personIds,Integer[] roleIds){
        return personService.personRole(personIds, roleIds);
    }
}
