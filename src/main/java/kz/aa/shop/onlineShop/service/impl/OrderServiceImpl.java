package kz.aa.shop.onlineShop.service.impl;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.repository.OrderRepository;
import kz.aa.shop.onlineShop.service.OrderService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user) {
        return orderRepository.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user);
    }

    @Override
    public Order findByUserAndIsConfirmedIsFalse(User user) {
        return orderRepository.findByUserAndIsConfirmedIsFalse(user);
    }
}
