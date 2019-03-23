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
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@SecondaryTable(name = "order_items", pkJoinColumns = @PrimaryKeyJoinColumn(name = "authorId", referencedColumnName = "id"))
@Table(name = "orders", schema = "public")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany
    private List<OrderItem> orderItemList;

    private LocalDateTime orderTime;

    private boolean isConfirmed;
}
