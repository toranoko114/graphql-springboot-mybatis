package com.course.graphql.springboot.mybatis.controller;

import com.course.graphql.springboot.mybatis.controller.message.EmployeeRequest;
import com.course.graphql.springboot.mybatis.controller.message.EmployeeResponse;
import com.course.graphql.springboot.mybatis.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeGraphqlController {

  private final EmployeeService service;
  private final ModelMapper modelMapper;

  @QueryMapping
  public EmployeeResponse fetchEmployeeById(@Argument String employeeId) {
    return this.modelMapper.map(this.service.fetchEmployeeById(employeeId), EmployeeResponse.class);
  }

  @QueryMapping
  public List<EmployeeResponse> fetchEmployeeAll() {
    return List.of(
        this.modelMapper.map(this.service.fetchEmployeeAll(), EmployeeResponse[].class)
    );
  }

  @MutationMapping
  public EmployeeResponse createEmployee(@Argument("input") EmployeeRequest request) {
    return this.modelMapper.map(this.service.create(request), EmployeeResponse.class);
  }

  @MutationMapping
  public EmployeeResponse updateEmployee(@Argument("employeeId") String employeeId,
      @Argument("input") EmployeeRequest request) {
    return this.modelMapper.map(this.service.update(employeeId, request), EmployeeResponse.class);
  }

  @MutationMapping
  public String deleteEmployee(@Argument("employeeId") String employeeId) {
    this.service.deleteById(employeeId);
    return employeeId;
  }
}
