package kz.aa.shop.onlineShop.service.impl.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.repository.base.CustomerOrderRepository;
import kz.aa.shop.onlineShop.service.CustomerOrderService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerOrderServiceImpl extends BaseServiceImpl<CustomerOrder, Long> implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public CustomerOrder findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user) {
        return customerOrderRepository.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user);
    }

    @Override
    public List<CustomerOrder> findAllByConfirmedIsTrue() {
        return customerOrderRepository.findByIsConfirmedIsTrue();
    }

    @Override
    public CustomerOrder findByUserAndIsConfirmedIsFalse(User user) {
        return customerOrderRepository.findByUserAndIsConfirmedIsFalse(user);
    }
}
