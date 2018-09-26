//package com.demospringboot.demo.security;
//
//import RoleMapper;
//import UserMapper;
//import User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//
///**
// * @Description 用户信息服务
// * @Author xg
// * @Date 2018/9/20 10:40
// */
//@Component
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = this.userMapper.findUserByName(username);
//
//        if(user == null) throw new UsernameNotFoundException("用户名"+username+"不存在！");
//
//        Collection<SimpleGrantedAuthority> collection = new HashSet<>();
//
//        Iterator<String> iterator = this.roleMapper.findRolesByUserId(user.getId()).iterator();
//
//        while (iterator.hasNext()){
//            collection.add(new SimpleGrantedAuthority(iterator.next()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
//    }
//}
