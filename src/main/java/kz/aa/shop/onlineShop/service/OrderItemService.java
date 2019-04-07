package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface OrderItemService extends BaseService<OrderItem, Long> {
    List<OrderItem> findByCustomerOrder(CustomerOrder customerOrder);
    OrderItem findByTypeCategoryAndIdItem(TypeCategory typeCategory, Long id);
    Long countByCustomerOrder_UserAndCustomerOrder_Confirmed(User user, Boolean confirmed);

    void saveAll(List<OrderItem> orderItems);
}
