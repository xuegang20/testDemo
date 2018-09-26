package com.demospringboot.bean.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/20 16:13
 */
public class UserReturnVerify {

    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("信息")
    private String info;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
