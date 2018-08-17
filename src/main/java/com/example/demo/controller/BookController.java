package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Book Info Controller")
@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@GetMapping
	@ApiOperation("查询详细信息")
	public String index() {
		return "hello book";
	}

}
