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

    Person queryPersonById(int id);

    int insertPersonRole(List<PersonRole> personRoleList);

    List<Person> selectiveMaxScorePersonByAge(Integer age);

    List<Person> selectiveMinScorePersonByAge(Integer age);

    List<Person> selectiveScorePersonByAge(Integer age);

    String queryPersonName(Integer id);
}
