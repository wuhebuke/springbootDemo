package com.company.springbootDemo.dao;

import com.company.springbootDemo.entity.Person;
import com.company.springbootDemo.entity.PersonRole;

import java.util.List;

/**
 * @author : farid
 * @date : 2023/4/25 19:22
 */
public interface PersonMapper {
    List<Person> queryPerson();

    int insertPersonRole(List<PersonRole> personRoleList);
}
