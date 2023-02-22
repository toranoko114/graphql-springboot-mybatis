package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.HistoryMapper;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.PersonalMapper;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import com.course.graphql.springboot.mybatis.service.entity.HistoryEntity;
import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeLogic {

  private final EmployeeMapper employeeMapper;
  private final PersonalMapper personalMapper;
  private final HistoryMapper historyMapper;

  @Transactional(propagation = Propagation.NESTED)
  public void create(EmployeeEntity employee, PersonalEntity personal, List<HistoryEntity> history) {
    this.employeeMapper.insert(employee);
    this.personalMapper.insert(personal);
    this.historyMapper.upsert(history);
  }

  @Transactional(propagation = Propagation.NESTED)
  public void update(String employeeId, EmployeeEntity employee, PersonalEntity personal,
      List<HistoryEntity> history) {
    this.employeeMapper.update(employeeId, employee);
    this.personalMapper.update(employeeId, personal);
    this.historyMapper.upsert(history);
  }

  @Transactional(propagation = Propagation.NESTED)
  public void deleteById(String employeeId) {
    this.employeeMapper.delete(employeeId);
    this.personalMapper.delete(employeeId);
    this.historyMapper.delete(employeeId);
  }

}
