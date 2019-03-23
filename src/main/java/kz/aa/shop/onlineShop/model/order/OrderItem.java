package kz.aa.shop.onlineShop.model.order;

import kz.aa.shop.onlineShop.model.TypeCategory;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items", schema = "public")
public class OrderItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    private Long idItem;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private TypeCategory typeCategory;
}
