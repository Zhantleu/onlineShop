package kz.aa.shop.onlineShop.repository.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
//    CustomerOrder findTopByOrderTimeAndIsConfirmedIsFalseAndByUser(User user);

    CustomerOrder findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user);
//    CustomerOrder findTopByMedicalCardOrderByModifiedOnDesc

    CustomerOrder findByUserAndIsConfirmedIsFalse(User user);

}
