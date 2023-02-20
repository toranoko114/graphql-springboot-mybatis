package com.course.graphql.springboot.mybatis.service.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryEntity {
  private LocalDate startDate;
  private String employeeId;
  private Integer departmentId;
  private String content;
}
