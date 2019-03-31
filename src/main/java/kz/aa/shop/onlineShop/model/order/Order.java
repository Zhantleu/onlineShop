package kz.aa.shop.onlineShop.model.order;


import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "orders", schema = "public")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private LocalDateTime orderTime;

    private boolean isConfirmed;

    public Order() {
    }

    public Order(User user, boolean isConfirmed) {
        this.user = user;
        this.isConfirmed = isConfirmed;
    }
}
