package kz.aa.shop.onlineShop.model.order;

import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "order_items", schema = "public")
public class OrderItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private CustomerOrder customerOrder;

    private Long idItem;

    private LocalDateTime orderItemTime;

    @Column(columnDefinition = "int default 1")
    private Integer amount;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private TypeCategory typeCategory;
}
