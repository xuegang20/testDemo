package com.demospringboot.mapper;

import com.demospringboot.model.role.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/20 11:18
 */
//@Mapper
@Repository
public interface RoleMapper {

    /**
     * 新建角色信息
     * @param role
     * @return
     */
    @Insert("INSERT INTO sys_role (role,name,modules,describe) VALUES(#{role.role}, #{role.name}, #{role.modules}, #{role.describe})")
    int insert(@Param("role") Role role);

    /**
     * 通过UserId得到对应的role
     * @param userId
     * @return
     */
    @Select("select role from sys_role where id in (select role_id from sys_user_role where user_id = #{userId})")
    List<String> findRolesByUserId(Long userId);
}
