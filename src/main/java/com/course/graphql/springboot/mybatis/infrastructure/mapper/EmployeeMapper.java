package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

  EmployeeDto fetchEmployeeById(@Param("employeeId") String employeeId);

  List<EmployeeDto> fetchEmployeeAll();

}
