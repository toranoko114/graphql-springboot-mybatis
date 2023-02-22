package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.dto.EmployeeDto;
import com.course.graphql.springboot.mybatis.service.entity.EmployeeEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

  EmployeeDto fetchEmployeeById(@Param("employeeId") String employeeId);

  List<EmployeeDto> fetchEmployeeAll();

  void insert(EmployeeEntity entity);

  void update(@Param("employeeId") String employeeId, @Param("entity") EmployeeEntity entity);

}
