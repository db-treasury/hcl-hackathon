package com.hcl.hackathon;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.hackathon.entity.Order;
import com.hcl.hackathon.repository.OrderRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryIntegrationTest{
    
    @Autowired
    private OrderRepository orderRepository;
   
    @Test
    public void testOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        assertNotNull(orders);
    }
}
