package com.example.demo.service;

import com.example.demo.bean.SysUser;

/**
 * @description:登录相关的方法
 * @author:@.
 * @Date:2017-12-10 11:58
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param userName 账号
     * @param password 密码
     * @return 返回登录结果及用户信息
     */
    SysUser login(String userName, String password);

    /**
     * 退出登录
     *
     * @param userName 账号
     * @return 结果信息
     */
    void logout(String userName);

}
