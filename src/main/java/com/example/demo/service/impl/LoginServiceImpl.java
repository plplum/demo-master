package com.example.demo.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SysUser;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.service.LoginService;
import com.example.demo.util.TokenUtils;


/**
 * @description:登录接口实现
 * @author:@.
 * @Date:2017-12-10 12:00
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(String userName, String password) {

        // 判断【用户名】、【密码】参数合法性
        /*if (null == userName || "".equalsIgnoreCase(userName)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.USER_NAME_ERROR);
        } else if (null == password || "".equalsIgnoreCase(password)) {
            jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
            jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.PASSWORD_ERROR);
        } else {
            // 查找用户，判断用户账号密码是否正确
            SysUser sysUser = sysUserMapper.findByUserName(userName);
            if (null == sysUser) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.USER_ERROR);
            } else if (!password.equalsIgnoreCase(sysUser.getUserPassword())) {
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.FAIL_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.PASSWORD_WRONG_ERROR);
            } else {
                // 账号密码正确，生成token
                String accessToken = TokenUtils.createJwtToken(userName);
                jsonObject.put(AppResultConstants.DATA, accessToken);
                jsonObject.put(AppResultConstants.STATUS, AppResultConstants.SUCCESS_STATUS);
                jsonObject.put(AppResultConstants.MSG, SysUserServiceImpl.LOGIN_SUCCESS);
            }
        }
*/
    	SysUser sysUser = sysUserMapper.login(userName, password);
    	//SysUser sysUser = sysUserMapper.selectByName(userName);
    	String accessToken = TokenUtils.createJwtToken(userName);
    	if (sysUser!=null) {
    		sysUser.setName(userName);
        	sysUser.setToken(accessToken);
		}else {
			throw new RuntimeException("用户名或密码错误.");
		}
        return sysUser;
    }

    @Override
    public void logout(String userName) {
       
    }
}
