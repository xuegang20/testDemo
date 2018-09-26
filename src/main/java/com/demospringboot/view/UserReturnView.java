package com.demospringboot.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/25 10:44
 */
public class UserReturnView {

    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("邮箱")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
