package com.course.graphql.springboot.mybatis.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
  private String employeeId;
  private String gender;
  private Integer departmentId;
  private String employeeName;
}
