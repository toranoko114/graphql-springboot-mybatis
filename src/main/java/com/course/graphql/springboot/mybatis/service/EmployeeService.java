package com.course.graphql.springboot.mybatis.service;

import com.course.graphql.springboot.mybatis.infrastructure.mapper.EmployeeMapper;
import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeMapper mapper;

  public EmployeeDto fetchEmployeeById(String employeeId) {
    return this.mapper.fetchEmployeeById(employeeId);
  }

  public List<EmployeeDto> fetchEmployeeAll() {
    return this.mapper.fetchEmployeeAll();
  }
}
