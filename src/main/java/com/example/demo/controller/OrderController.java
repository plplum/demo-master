package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Order;
import com.example.demo.bean.ResponseBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Order Info Controller")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private com.example.demo.service.OrderService orderService;

	@GetMapping
	@ApiOperation("查询详细信息")
	public String index() {
		return "hello book";
	}

	@ResponseBody
	@GetMapping(value = "/getOrder")
	@ApiOperation("根据id查询订单信息")
	public Order getOrder() {
		Order stu = orderService.getOrderById(1);
		return stu;
	}
	
	/*@ResponseBody
	@GetMapping(value = "/getAllOrder")
	@ApiOperation("查询所有订单信息")
	private List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}*/
	
	
	@ResponseBody
	@GetMapping(value = "/getAllOrder")
	@ApiOperation("查询所有订单信息")
	private ResponseBean<List<Order>> getAllOrder() {
		return new ResponseBean<>(orderService.getAllOrder());
	}
	
	@PostMapping(value = "/addOrder")
	@ApiOperation("新增订单")
	private String addOrder(@RequestBody Order order) {
		boolean flag = orderService.addOrder(order);
		if (flag) {
			return "0";
		}else {
			return "1";
		}
	}
	
	@PostMapping(value = "/updateOrder")
	@ApiOperation("修改订单")
	private int updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	/*@PostMapping(value = "/deleteOrder")
	@ApiOperation("删除订单")
	private int deleteOrder(@RequestParam int orderId) {
		return orderService.deleteOrderById(orderId);
	}*/

	@PostMapping(value = "/deleteOrder")
	@ApiOperation("删除订单")
	private ResponseBean<Integer> deleteOrder(@RequestParam int orderId) {
		return new ResponseBean<>(orderService.deleteOrderById(orderId));
	}
	
	
	
}
