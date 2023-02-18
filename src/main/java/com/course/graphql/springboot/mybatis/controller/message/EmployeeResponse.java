package com.course.graphql.springboot.mybatis.controller.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

  @JsonProperty("employeeId") private String employeeId;
  @JsonProperty("employeeName") private String employeeName;
  @JsonProperty("department") private Department department;
  @JsonProperty("gender") private String gender;

  @Data
  private static class Department {
    @JsonProperty("departmentId") private Integer departmentId;
    @JsonProperty("departmentName") private String departmentName;
  }

}
