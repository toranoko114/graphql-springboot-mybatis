package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.controller.message.EmployeeRequest;
import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeMapper mapper;
  private final ModelMapper modelMapper;

  public EmployeeDto fetchEmployeeById(String employeeId) {
    return this.mapper.fetchEmployeeById(employeeId);
  }

  public List<EmployeeDto> fetchEmployeeAll() {
    return this.mapper.fetchEmployeeAll();
  }

  public EmployeeDto create(EmployeeRequest request) {
    var entity = this.modelMapper.map(request, EmployeeEntity.class);
    this.mapper.insert(entity);
    return this.fetchEmployeeById(entity.getEmployeeId());
  }

}
