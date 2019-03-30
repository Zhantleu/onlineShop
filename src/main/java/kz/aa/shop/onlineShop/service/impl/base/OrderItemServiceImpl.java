package kz.aa.shop.onlineShop.service.impl.base;

import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
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
    public List<OrderItem> findByOrder(Order order) {
        return repository.findByOrder(order);
    }
}
