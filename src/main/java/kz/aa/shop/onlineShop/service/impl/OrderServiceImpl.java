package kz.aa.shop.onlineShop.service.impl;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.repository.OrderRepository;
import kz.aa.shop.onlineShop.service.OrderService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findTopByUserAndAndOrderTime(User user, LocalDateTime orderTime) {
        return orderRepository.findTopByUserAndAndOrderTime(user,orderTime);
    }

    @Override
    public Order findByUserAndConfirmedIsFalse(User user) {
        return orderRepository.findByUserAndConfirmedIsFalse(user);
    }
}
