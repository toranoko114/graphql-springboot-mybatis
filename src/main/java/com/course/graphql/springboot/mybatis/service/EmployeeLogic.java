package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.PersonalMapper;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeLogic {

  private final EmployeeMapper employeeMapper;
  private final PersonalMapper personalMapper;

  @Transactional(propagation = Propagation.NESTED)
  public void create(EmployeeEntity employee, PersonalEntity personal) {
    this.employeeMapper.insert(employee);
    this.personalMapper.insert(personal);
  }

}
