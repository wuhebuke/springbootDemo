package com.company.springbootDemo.service;

import com.company.springbootDemo.dao.PersonMapper;
import com.company.springbootDemo.entity.PersonRole;
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
    @Resource
    private PersonMapper personMapper;
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
}
