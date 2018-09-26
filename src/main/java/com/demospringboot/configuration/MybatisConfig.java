package com.demospringboot.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description mybatis配置
 * @Author xg
 * @Date 2018/9/20 14:38
 */
@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/*Mapper.xml");
        sessionFactory.setMapperLocations(resources);
        return sessionFactory;
    }
}
