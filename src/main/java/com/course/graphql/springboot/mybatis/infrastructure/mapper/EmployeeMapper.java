package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

  @Select("SELECT EMPLOYEE_ID, EMPLOYEE_NAME FROM EMPLOYEE WHERE EMPLOYEE_ID = #{employeeId}")
  EmployeeDto fetchEmployeeById(@Param("employeeId") String employeeId);

}
