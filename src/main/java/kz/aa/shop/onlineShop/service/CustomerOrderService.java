package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.service.base.BaseService;

import java.util.List;

public interface CustomerOrderService extends BaseService<CustomerOrder, Long> {
    CustomerOrder findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user);

    List<CustomerOrder> findAllByConfirmedIsTrue();

    CustomerOrder findByUserAndIsConfirmedIsFalse(User user);
}
