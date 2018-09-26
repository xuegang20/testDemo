package com.demospringboot.controller;

import com.demospringboot.bean.UserReturnInfo;
import com.demospringboot.model.user.User;
import com.demospringboot.service.UserService;
import com.demospringboot.utils.ResultModel;
import com.demospringboot.view.UserReturnView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/15 14:01
 */
@RestController
@RequestMapping(value = "/user" ,produces = {"application/json"})
@Api(value = "/user" , description = "用户api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "all",method = RequestMethod.GET,produces = {"application/json"})
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    public ResultModel<List<UserReturnView>> findAll(){

        List<UserReturnView> all = userService.findAll();
        if(all!=null&&all.size()>0) return new ResultModel<>(true,"查询成功",all);
        return new ResultModel<>(false,"查询失败");
    }

    @RequestMapping(value = "{loginName}",method = RequestMethod.GET,produces = {"application/json"})
    @ApiOperation(value = "根据loginName查询用户", notes = "根据loginName查询用户")
    public ResultModel<UserReturnView> findUserByName(
            @ApiParam @PathVariable(value = "loginName") String loginName){

        UserReturnView user = userService.findUserByLoginName(loginName);
        if(user!=null) return new ResultModel<>(true,"查询成功",user);
        return new ResultModel<>(false,"查询失败");
    }

    @RequestMapping(value = "",method = RequestMethod.POST,produces = {"application/json"})
    @ApiOperation(value = "注册新用户", notes = "注册新用户")
    public UserReturnInfo insertUser(
            @ApiParam @RequestBody User user){

        UserReturnInfo userReturnInfo = userService.registerUser(user);
        return userReturnInfo;
    }
}
