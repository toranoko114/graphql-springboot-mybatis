package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.entity.HistoryEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {

  void insert(List<HistoryEntity> historyList);

  void update(List<HistoryEntity> historyList);

}
