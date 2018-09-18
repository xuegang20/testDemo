package com.demospringboot.demo.service.impl;

import com.demospringboot.demo.mapper.UserMapper;
import com.demospringboot.demo.model.User;
import com.demospringboot.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/18 9:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> findAll() {
        logger.info("查询所有用户");
        return userMapper.findAll();
    }

    @Override
    public User findUserByName(String name) {
        logger.info("根据name查询用户");
        return userMapper.findUserByName(name);
    }
}
