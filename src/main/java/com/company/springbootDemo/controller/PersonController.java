package com.company.springbootDemo.controller;

import com.company.springbootDemo.entity.Person;
import com.company.springbootDemo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : farid
 * @date : 2023/4/25 19:22
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping("/queryPerson")
    public List<Person> queryPerson() {
        return personService.queryPerson();
    }

    @GetMapping("/queryPersonById")
    public Person queryPersonById(int id){
        return personService.queryPersonById(id);
    }

    @PostMapping("/insertPersonRole")
    public int insertPersonRole(Integer[] personIds,Integer[] roleIds){
        return personService.personRole(personIds, roleIds);
    }

    @GetMapping("/selectivePerson")
    public List<Person> selectivePerson(Integer flag,Integer age){
        return personService.selectivePerson(flag,age);
    }

    @GetMapping("/queryPersonName")
    public String queryPersonName(Integer id){
        return personService.queryPersonName(id);
    }
}