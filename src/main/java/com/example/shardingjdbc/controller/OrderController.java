package com.example.shardingjdbc.controller;
 
 
import com.example.shardingjdbc.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import javax.annotation.Resource;
 
/**
 * @author Lucifer
 */
@RestController
public class OrderController {
 
    @Resource
    private OrderService orderService;
 
    @GetMapping(value = "/add")
    public void addOrder() {
        orderService.addOrder();
    }
 
    @GetMapping(value = "/find")
    public void findOrder() {
        orderService.findOrder();
    }
    
}