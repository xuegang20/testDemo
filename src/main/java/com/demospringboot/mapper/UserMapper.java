package com.demospringboot.mapper;

import com.demospringboot.model.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description User映射类
 * @Author xg
 * @Date 2018/9/15 12:15
 */
@Mapper
@Repository
public interface UserMapper {

    //@Select("SELECT * FROM sys_user WHERE name = #{name}")
    //User findUserByName(@Param("name") String name);
    //
    //@Insert("INSERT INTO sys_user(name,login_name,password,email) VALUES(#{user.name}, #{user.login_name}, #{user.password}, #{user.email})")
    //int insert(@Param("user") User user);
    //
    //@Select("SELECT * FROM sys_user")
    //List<User> findAll();

    /**
     * 获取user列表
     * @param loginName
     * @param pageSize
     * @param page
     * @return
     */
    public ArrayList<User> usersList(@Param("loginName")String loginName, @Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * 创建新用户
     * @param user
     * @return
     */
    public Long insertUser(@Param("user") User user);

    /**
     * 根据loginName查询
     * @param loginName
     * @return
     */
    public User findByLoginName(@Param("loginName") String loginName);

    /**
     * 根据email查询
     * @param email
     * @return
     */
    User findUserByEmail(@Param("email") String email);
}
