package com.demospringboot.demo.service;

import com.demospringboot.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/18 9:58
 */
@Service
public interface UserService {

    List<User> findAll();

    User findUserByName(String name);
}
