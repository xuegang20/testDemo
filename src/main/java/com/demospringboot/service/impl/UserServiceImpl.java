package com.demospringboot.service.impl;

import com.demospringboot.bean.UserReturnInfo;
import com.demospringboot.bean.user.UserReturnVerify;
import com.demospringboot.mapper.UserMapper;
import com.demospringboot.model.user.User;
import com.demospringboot.service.UserService;
import com.demospringboot.utils.KeyDigestUtil;
import com.demospringboot.view.UserReturnView;
import org.apache.logging.log4j.LogManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/18 9:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<UserReturnView> findAll() {
        logger.info("查询所有用户");
        //return userMapper.findAll();
        ArrayList<User> users = userMapper.usersList(null, 2, 1);
        List<UserReturnView> views = new ArrayList<>();

        if(users!=null&&users.size()>0){
            for (User user : users) {
                UserReturnView view = new UserReturnView();
                BeanUtils.copyProperties(user,view);
                views.add(view);
                view = null;
            }
        }
        return views;
    }

    @Override
    public UserReturnView findUserByLoginName(String loginName) {
        logger.info("根据name查询用户");
        //return userMapper.findUserByName(name);

        User byLoginName = userMapper.findByLoginName(loginName);
        UserReturnView view = new UserReturnView();
        if(byLoginName!=null) BeanUtils.copyProperties(byLoginName,view);
        return view;
    }

    @Transactional
    @Override
    public UserReturnInfo registerUser(User user) {

        UserReturnVerify ver = null;

        if (user.getLoginName() != null) {
            ver = verifyUserByLoginName(user.getLoginName());
        }
        if (user.getEmail() != null) {
            User u = this.userMapper.findUserByEmail(user.getEmail());
            UserReturnVerify v = new UserReturnVerify();
            if (u != null) {
                v.setInfo("该邮箱已被注册");
                ver = v;
            }
        }

        UserReturnInfo msg = new UserReturnInfo();
        msg.setLoginName(user.getLoginName());
        msg.setName(user.getName());
        try {
            if ((ver.getInfo().equals("登录名已存在！"))
                    || (ver.getInfo().equals("该邮箱已被注册"))) {
                msg.setStatus("该账户已注册，不可用");
                //return msg;
            } else {
                User u = new User();
                /*用户密码加密*/
                String newpassword = KeyDigestUtil.encryptByMD5(user.getPassword());
                u.setPassword(newpassword);
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setLoginName(user.getLoginName());
                this.userMapper.insertUser(u);
                logger.info("创建新用户");
                msg.setStatus("注册成功");
                //return msg;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            msg.setStatus("注册失败");
        }

        return msg;
    }

    /**
     * 验证登录名
     * @param loginName
     * @return
     */
    private UserReturnVerify verifyUserByLoginName(String loginName) {

        UserReturnVerify ver = new UserReturnVerify();
        String regex = "([\\w]|[\\u4e00-\\u9fa5])+";
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(loginName);
            if (!matcher.matches()) {
                ver.setStatus("illegal_input");
            } else {
                User user = this.userMapper.findByLoginName(loginName);
                if(user!=null){
                    ver.setInfo("登录名已存在！");
                }else {
                    ver.setInfo("available");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ver;
    }
}
