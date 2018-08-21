package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ResponseBean;
import com.example.demo.bean.SysUser;
import com.example.demo.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description:登录
 * @author:.
 * @Date:2017-12-03 16:53
 */
@RestController
@RequestMapping({"/login"})
@Api(tags="Login Controller")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping(value = "/login")
	@ApiOperation("用户登录")
    public ResponseBean<SysUser> login(String userName,String password) {
    	SysUser sysUser = loginService.login(userName,password);
        return new ResponseBean<>(sysUser);
    }

    @ResponseBody
    @PostMapping(value = "logout")
	@ApiOperation("用户登出")
    public Object logout(String userName) {
        return "";
    }



}
