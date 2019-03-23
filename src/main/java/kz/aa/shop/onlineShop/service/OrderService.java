package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.service.base.BaseService;

public interface OrderService extends BaseService<Order,Long> {
    Order findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user);

    Order findByUserAndIsConfirmedIsFalse(User user);
}
