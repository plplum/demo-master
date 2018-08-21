package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.SysUser;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private SysUserMapper userDao;

	@Override
	public SysUser getUserByName(String userName) {
		return userDao.selectByName(userName);
	}

	
	
	

}