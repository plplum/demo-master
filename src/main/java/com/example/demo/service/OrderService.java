package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Order;

public interface OrderService {
	
    public Order getOrderById(int orderId);

    boolean addOrder(Order order);
    
    public List<Order> getAllOrder();
    
    int updateOrder(Order order);
    
    int deleteOrderById(int orderId);
}