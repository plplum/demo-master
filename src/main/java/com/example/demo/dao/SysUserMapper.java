package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByName(String userName);
    
    SysUser login(@Param("userName") String userName, @Param("password") String password);
}