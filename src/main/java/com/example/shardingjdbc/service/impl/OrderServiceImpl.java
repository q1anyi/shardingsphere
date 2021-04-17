package com.example.shardingjdbc.service.impl;
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingjdbc.dao.OrderDao;
import com.example.shardingjdbc.entity.Order;
import com.example.shardingjdbc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
 
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
 
/**
 * @author Lucifer
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
 

    private final OrderDao orderDao;
 
    @Override
    public void addOrder() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setPrice(new BigDecimal(Math.random()));
            order.setUserId(new Random().nextLong());
            order.setStatus("0");
            orderDao.insert(order);
        }
    }
 
 
   //执行新增后，将两库的数据各取一条，来测试
    @Override
    public void findOrder() {
        List<Long> list=new ArrayList<>();
        list.add(418415166183440384L);
        list.add(418417197166100481L);
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("order_id", list);
        orderDao.selectList(queryWrapper);
    }
}