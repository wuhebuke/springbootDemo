package com.company.springbootDemo.service;

import com.company.common.utils.StringUtils;
import com.company.springbootDemo.dao.PersonMapper;
import com.company.springbootDemo.entity.Person;
import com.company.springbootDemo.entity.PersonRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

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

    @Resource
    private PersonMapper personMapper;

    @Resource
    private TransactionTemplate transactionTemplate;

    public static final String FLAG="0";


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
        //存在NullPointerException
        if (StringUtils.isNotNull(flag)){
            if (flag==0){
                return personMapper.selectiveMaxScorePersonByAge(age);
            }else {
                return personMapper.selectiveMinScorePersonByAge(age);
            }
        }else {
            return personMapper.selectiveScorePersonByAge(age);
        }
    }
}