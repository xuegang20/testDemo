//package com.demospringboot.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Description spring security启动配置
// * @Author xg
// * @Date 2018/9/19 17:53
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //允许进入页面方法前检查
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //@Autowired
//    //private MyAuthenticationProvider provider;//自定义验证
//    //@Autowired
//    private MyUserDetailsService userDetailsService;//自定义用户服务
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//
//                //.antMatchers(StaticParams.PATHREGX.NOAUTH,
//                //        StaticParams.PATHREGX.CSS,StaticParams.PATHREGX.JS,StaticParams.PATHREGX.IMG).permitAll()//无需访问权限
//                //
//                //.antMatchers(StaticParams.PATHREGX.AUTHADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//admin角色访问权限
//                //
//                //.antMatchers(StaticParams.PATHREGX.AUTHUSER).hasAuthority(StaticParams.USERROLE.ROLE_USER)//user角色访问权限
//
//                .anyRequest()//all others request authentication
//                .authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //将验证过程交给自定义验证工具
//        //auth.authenticationProvider(provider);
//        auth.userDetailsService(userDetailsService);
//    }
//
//    /**
//     * 需要配置这个支持password模式 support password grant type
//     *
//     * @return
//     * @throws Exception
//     */
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    //@Override
//    //protected void configure(HttpSecurity http) throws Exception {
//    //    super.configure(http);
//    //}
//}
