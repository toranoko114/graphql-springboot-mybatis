package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.controller.message.EmployeeRequest;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import java.util.List;
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
    return this.mapper.fetchEmployeeById(employeeId);
  }

  public List<EmployeeDto> fetchEmployeeAll() {
    return this.mapper.fetchEmployeeAll();
  }

  public EmployeeDto create(EmployeeRequest request) {
    var employee = this.modelMapper.map(request, EmployeeEntity.class);
    var personal = this.modelMapper.map(request, PersonalEntity.class);
    this.logic.create(employee, personal);
    return this.fetchEmployeeById(employee.getEmployeeId());
  }

}
