package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.controller.message.EmployeeRequest;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import com.course.graphql.springboot.mybatis.service.entity.HistoryEntity;
import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeMapper mapper;
  private final ModelMapper modelMapper;
  private final EmployeeLogic logic;

  public EmployeeDto fetchEmployeeById(String employeeId) {
    return Optional.of(this.mapper.fetchEmployeeById(employeeId))
        .orElseThrow(() -> new RuntimeException("社員IDに該当する社員が存在しません。"));
  }

  public List<EmployeeDto> fetchEmployeeAll() {
    return this.mapper.fetchEmployeeAll();
  }

  public EmployeeDto create(EmployeeRequest request) {
    var employee = this.modelMapper.map(request, EmployeeEntity.class);
    var personal = this.modelMapper.map(request, PersonalEntity.class);
    var history = List.of(this.modelMapper.map(request.getHistoryList(), HistoryEntity[].class));
    this.logic.create(employee, personal, history);
    return this.fetchEmployeeById(employee.getEmployeeId());
  }

  public EmployeeDto update(String employeeId, EmployeeRequest request) {
    this.fetchEmployeeById(employeeId);
    var employee = this.modelMapper.map(request, EmployeeEntity.class);
    var personal = this.modelMapper.map(request, PersonalEntity.class);
    var history = List.of(this.modelMapper.map(request.getHistoryList(), HistoryEntity[].class));
    this.logic.update(employeeId, employee, personal, history);
    return this.fetchEmployeeById(employeeId);
  }

  public void deleteById(String employeeId) {
    this.logic.deleteById(employeeId);
  }

}
