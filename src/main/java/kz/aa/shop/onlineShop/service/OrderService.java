package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.service.base.BaseService;

import java.time.LocalDateTime;

public interface OrderService extends BaseService<Order,Long> {
    Order findTopByUserAndAndOrderTime(User user, LocalDateTime orderTime);

    Order findByUserAndConfirmedIsFalse(User user);
}
