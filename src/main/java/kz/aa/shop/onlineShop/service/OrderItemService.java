package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.base.BaseService;

import java.util.List;

public interface OrderItemService extends BaseService<OrderItem, Long> {
    List<OrderItem> findByCustomerOrder(CustomerOrder customerOrder);
    OrderItem findByTypeCategoryAndIdItem(TypeCategory typeCategory, Long id);
}
