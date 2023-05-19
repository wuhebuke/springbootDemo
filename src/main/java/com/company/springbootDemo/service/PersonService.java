package com.company.springbootDemo.service;

import com.company.springbootDemo.dao.PersonMapper;
import com.company.springbootDemo.entity.Person;
import com.company.springbootDemo.entity.PersonRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : farid
 * @date : 2023/5/4 20:18
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PersonService {

    public static final String FLAG="0";

    @Resource
    private PersonMapper personMapper;

    public List<Person> queryPerson(){
        return personMapper.queryPerson();
    }

    public Person queryPersonById(int id){
        return personMapper.queryPersonById(id);
    }

    public int personRole(Integer[] personIds,Integer[] roleIds){
        List<PersonRole> list = new ArrayList<>();
        for (Integer personId : personIds) {
            for (Integer roleId : roleIds) {
                PersonRole pr = new PersonRole();
                pr.setPersonId(personId);
                pr.setRoleId(roleId);
                list.add(pr);
            }
        }
        return personMapper.insertPersonRole(list);
    }

    public List<Person> selectivePerson(Integer flag,Integer age){

        if (flag==1){  //存在NullPointerException
            return personMapper.selectiveMaxScorePersonByAge(age);
        }else if (flag==0){
            return personMapper.selectiveMinScorePersonByAge(age);
        }else {
            return personMapper.selectiveScorePersonByAge(age);
        }
    }
}