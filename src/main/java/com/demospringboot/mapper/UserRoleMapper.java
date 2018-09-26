package com.demospringboot.mapper;

import com.demospringboot.model.role.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/20 11:26
 */
//@Mapper
@Repository
public interface UserRoleMapper {

    /**
     * 新建用户角色关系
     * @param userRole
     * @return
     */
    @Insert("INSERT INTO sys_user_role (user_id,role_id) VALUES(#{userRole.userId}, #{userRole.roleId})")
    int insert(@Param("userRole") UserRole userRole);
}
