package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PersonalMapper {

  void insert(PersonalEntity entity);

  void update(@Param("employeeId") String employeeId, @Param("entity") PersonalEntity entity);

  @Delete("DELETE FROM PERSONAL WHERE EMPLOYEE_ID = #{employeeId}")
  void delete(String employeeId);

}
