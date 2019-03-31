package kz.aa.shop.onlineShop.service.impl.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.repository.base.OrderRepository;
import kz.aa.shop.onlineShop.service.OrderService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImpl extends BaseServiceImpl<CustomerOrder, Long> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CustomerOrder findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user) {
        return orderRepository.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user);
    }

    @Override
    public CustomerOrder findByUserAndIsConfirmedIsFalse(User user) {
        return orderRepository.findByUserAndIsConfirmedIsFalse(user);
    }
}
