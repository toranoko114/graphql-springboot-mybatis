package com.course.graphql.springboot.mybatis.controller;

import com.course.graphql.springboot.mybatis.controller.message.EmployeeResponse;
import com.course.graphql.springboot.mybatis.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeGraphqlController {

  private final EmployeeService service;
  private final ModelMapper modelMapper;

  @QueryMapping
  public EmployeeResponse fetchEmployeeById(@Argument final String employeeId) {
    return this.modelMapper.map(this.service.fetchEmployeeById(employeeId), EmployeeResponse.class);
  }

}
