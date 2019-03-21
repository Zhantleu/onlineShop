package kz.aa.shop.onlineShop.model.order;


import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders", schema = "public")
public class Order extends BaseEntity {
    @OneToMany
    private User user;

    @OneToMany
    private OrderItem orderItem;
}
