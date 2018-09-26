package com.demospringboot.bean;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/20 16:32
 */
public class UserReturnInfo {
    @Id
    @ApiModelProperty("ID")
    private String oid;
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("loginName")
    private String loginName;
    @ApiModelProperty("token")
    private String token;
    @ApiModelProperty("status")
    private String status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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

}
