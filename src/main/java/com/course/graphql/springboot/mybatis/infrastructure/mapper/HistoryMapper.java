package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.entity.HistoryEntity;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {

  void upsert(List<HistoryEntity> historyList);

  @Delete("DELETE FROM HISTORY WHERE EMPLOYEE_ID = #{employeeId}")
  void delete(String employeeId);

}
