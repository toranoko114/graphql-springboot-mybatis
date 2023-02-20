package com.course.graphql.springboot.mybatis.controller.message;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import java.time.LocalDate;
import java.util.List;
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
  @JsonProperty("birthday") @JsonFormat(pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class) private LocalDate birthday;
  @JsonProperty("telephoneNumber") private String telephoneNumber;
  @JsonProperty("mailAddress") private String mailAddress;
  @JsonProperty("historyList") private List<History> historyList;

  @Data
  private static class History {
    @JsonProperty("startDate") @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class) private LocalDate startDate;
    @JsonProperty("employeeId") private String employeeId;
    @JsonProperty("departmentId") private Integer departmentId;
    @JsonProperty("content") private String content;
  }

}
