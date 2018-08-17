package com.example.demo.controller;

import java.util.Date;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Api(tags="UserOrder Controller")
@RestController
@RequestMapping(value = "/index")
public class IndexController {
	
	@Value(value = "${roncoo.secret}")
	private String secret;
	
	@Value(value = "${roncoo.number}")
	private int id;
	
	@Value(value = "${roncoo.desc}")
	private String desc;

	//@RequestMapping
	@GetMapping
	@ApiOperation("查询详细信息")
	public String index() {
		
		log.debug("this is a log test, debug");
		log.info("this is a log test, info");
		log.warn("this is a log test, warn");
		
		return "hello world";
	}

	//@RequestParam 简单类型的绑定，可以出来get和post
	//@RequestMapping(value = "/get")
	@GetMapping(value = "/get")
	@ApiOperation("根据姓名查询详细信息")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		map.put("secret", secret);
		map.put("id", id);
		map.put("desc", desc);
		return map;
	}

	// @PathVariable 获得请求url中的动态参数
	@GetMapping(value = "/get/{id}/{name}")
	@ApiOperation("根据ID和姓名查询详细信息")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	
	@PutMapping(value = "/addUser")
	@ApiOperation("新增用户信息")
	public void addUser(@RequestBody User user) {
		System.out.println(user.getName());
	}
	

}