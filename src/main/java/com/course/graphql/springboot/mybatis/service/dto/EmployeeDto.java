package com.course.graphql.springboot.mybatis.service.dto;

import com.course.graphql.springboot.mybatis.enums.Department;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private String employeeId;
  private String employeeName;
  private Department department;
  private String gender;
  private PersonalDto personal;
  private List<HistoryDto> historyList;
}
