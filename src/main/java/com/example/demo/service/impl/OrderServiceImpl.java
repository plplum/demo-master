package com.example.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Order;
import com.example.demo.dao.OrderMapper;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderMapper orderDao;

	@Override
	public Order getOrderById(int orderId) {
		return orderDao.selectByPrimaryKey(orderId);
	}

	@Override
	public boolean addOrder(Order order) {
		boolean result = false;
        try {
        	orderDao.insertSelective(order);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.selectAll();
	}

	@Override
	public int updateOrder(Order order) {
		return orderDao.updateByPrimaryKeySelective(order);
	}

	@Override
	public int deleteOrderById(int orderId) {
		return orderDao.deleteByPrimaryKey(orderId);
	}
	
	

}