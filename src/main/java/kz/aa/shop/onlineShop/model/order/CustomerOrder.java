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
public class CustomerOrder extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private LocalDateTime orderTime;

    private boolean isConfirmed;

    private Double totalPrice;

    public CustomerOrder() {
    }

    public CustomerOrder(User user, boolean isConfirmed) {
        this.user = user;
        this.isConfirmed = isConfirmed;
    }
}
