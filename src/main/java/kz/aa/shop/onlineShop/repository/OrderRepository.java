package kz.aa.shop.onlineShop.repository;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findTopByUserAndAndOrderTime(User user, LocalDateTime orderTime);

    Order findByUserAndConfirmedIsFalse(User user);

}
