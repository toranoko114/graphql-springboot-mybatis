package com.course.graphql.springboot.mybatis.infrastructure.mapper;

import com.course.graphql.springboot.mybatis.service.entity.PersonalEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalMapper {

  void insert(PersonalEntity entity);

}
