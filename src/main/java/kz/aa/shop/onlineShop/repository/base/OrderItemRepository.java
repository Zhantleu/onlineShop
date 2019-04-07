package kz.aa.shop.onlineShop.repository.base;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByCustomerOrder(CustomerOrder customerOrder);
    OrderItem findByTypeCategoryAndIdItem(TypeCategory typeCategory, Long id);

    @QueryHints({@QueryHint(name="org.hibernate.cacheable", value="true")})
    @Query("select count(orderItem) from OrderItem orderItem inner join orderItem.customerOrder c where c.isConfirmed = :confirmed and c.user = :user")
    Long countByCustomerOrder_UserAndCustomerOrder_Confirmed(User user, Boolean confirmed);
}
