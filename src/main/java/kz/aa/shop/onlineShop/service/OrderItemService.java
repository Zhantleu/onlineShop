package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.service.base.BaseService;

import java.util.List;

public interface OrderItemService extends BaseService<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}
