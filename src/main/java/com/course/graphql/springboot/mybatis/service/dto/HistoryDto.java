package com.course.graphql.springboot.mybatis.service.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {
  private String employeeId;
  private Integer departmentId;
  private LocalDate startDate;
  private String content;
}
