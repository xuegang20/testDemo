package com.demospringboot.service;

import com.demospringboot.bean.UserReturnInfo;
import com.demospringboot.model.user.User;
import com.demospringboot.view.UserReturnView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/18 9:58
 */
@Service
public interface UserService {

    List<UserReturnView> findAll();

    UserReturnView findUserByLoginName(String loginName);

    UserReturnInfo registerUser(User user);
}
