package kz.aa.shop.onlineShop.service.impl.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.repository.base.OrderItemRepository;
import kz.aa.shop.onlineShop.service.OrderItemService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem, Long> implements OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    @Override
    public List<OrderItem> findByCustomerOrder(CustomerOrder customerOrder) {
        return repository.findByCustomerOrder(customerOrder);
    }

    @Override
    public OrderItem findByTypeCategoryAndIdItemAndCustomerOrder( Long id, CustomerOrder order) {
        return repository.findByTypeCategoryAndIdItemAndCustomerOrder(id, order);
    }

    @Override
    public Long countByCustomerOrder_UserAndCustomerOrder_Confirmed(User user, Boolean confirmed) {
        return repository.countByCustomerOrder_UserAndCustomerOrder_Confirmed(user, confirmed);
    }

    @Override
    public void saveAll(List<OrderItem> orderItems) {
        repository.saveAll(orderItems);
    }
}
