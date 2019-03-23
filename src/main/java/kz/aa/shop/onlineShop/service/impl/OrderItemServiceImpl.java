package kz.aa.shop.onlineShop.service.impl;

import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.repository.OrderItemRepository;
import kz.aa.shop.onlineShop.service.OrderItemService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, Long> implements OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    @Override
    public List<OrderItem> findByOrder(Order order) {
        return repository.findByOrder(order);
    }
}
