package com.demospringboot.demo.controller;

import com.demospringboot.demo.model.User;
import com.demospringboot.demo.service.UserService;
import com.demospringboot.demo.utils.ResultModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultModel<List<User>> findAll(){

        List<User> all = userService.findAll();
        if(all!=null&&all.size()>0) return new ResultModel<>(true,"查询成功",all);
        return new ResultModel<>(false,"查询失败");
    }

    @RequestMapping(value = "{name}",method = RequestMethod.GET,produces = {"application/json"})
    @ApiOperation(value = "根据name查询用户", notes = "根据name查询用户")
    public ResultModel<User> findUserByName(
            @ApiParam @PathVariable(value = "name") String name){

        User user = userService.findUserByName(name);
        if(user!=null) return new ResultModel<>(true,"查询成功",user);
        return new ResultModel<>(false,"查询失败");
    }
}
