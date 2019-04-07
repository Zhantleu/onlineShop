package kz.aa.shop.onlineShop.repository.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    CustomerOrder findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(User user);
    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    CustomerOrder findByUserAndIsConfirmedIsFalse(User user);

}
