package com.course.graphql.springboot.mybatis.controller.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
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
  @JsonProperty("personal") private Personal personal;

  @Data
  private static class Department {
    @JsonProperty("departmentId") private Integer departmentId;
    @JsonProperty("departmentName") private String departmentName;
  }

  @Data
  public static class Personal {
    @JsonProperty("employeeId") private String employeeId;
    @JsonProperty("telephoneNumber") private String telephoneNumber;
    @JsonProperty("mailAddress") private String mailAddress;
    @JsonProperty("birthday") @JsonFormat(pattern = "yyyy-MM-dd") @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
  }

}
