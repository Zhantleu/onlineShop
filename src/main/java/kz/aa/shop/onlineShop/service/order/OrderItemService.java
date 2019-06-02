package kz.aa.shop.onlineShop.service.order;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.service.base.BaseService;

import java.util.List;

public interface OrderItemService extends BaseService<OrderItem, Long> {
    List<OrderItem> findByCustomerOrder(CustomerOrder customerOrder);

    OrderItem findByTypeCategoryAndIdItemAndCustomerOrder(Long id, CustomerOrder order);

    Long countByCustomerOrder_UserAndCustomerOrder_Confirmed(User user, Boolean confirmed);

    void saveAll(List<OrderItem> orderItems);
}
