package com.demospringboot.demo.mapper;

import com.demospringboot.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description User映射类
 * @Author xg
 * @Date 2018/9/15 12:15
 */
//@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, PASSWORD) VALUES(#{name}, #{password})")
    int insert(@Param("name") String name, @Param("password") String password);

    @Select("SELECT * FROM USER")
    List<User> findAll();

}
