package kz.aa.shop.onlineShop.repository.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//    Order findTopByOrderTimeAndIsConfirmedIsFalseAndByUser(User user);

    Order findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user);
//    Order findTopByMedicalCardOrderByModifiedOnDesc

    Order findByUserAndIsConfirmedIsFalse(User user);

}
