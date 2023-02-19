package com.course.graphql.springboot.mybatis.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

/**
 * @see 'https://github.com/graphql-java/graphql-java-extended-scalars'
 */
@Configuration
public class ScalarConfig {

  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
  }
}
