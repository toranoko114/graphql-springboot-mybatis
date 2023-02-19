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
public class EmployeeRequest {
  @JsonProperty("employeeId") private String employeeId;
  @JsonProperty("employeeName") private String employeeName;
  @JsonProperty("gender") private String gender;
  @JsonProperty("departmentId") private Integer departmentId;
}
