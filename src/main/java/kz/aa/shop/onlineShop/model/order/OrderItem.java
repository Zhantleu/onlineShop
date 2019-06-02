package kz.aa.shop.onlineShop.model.order;

import kz.aa.shop.onlineShop.model.property.enumeration.SubTypeCategory;
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
    private Long amount;

    @Column
    private Double totalPrice;

    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private SubTypeCategory subTypeCategory;

    public OrderItem(CustomerOrder customerOrder, Long id, Long idItem, LocalDateTime orderItemTime, Long amount, Double price, SubTypeCategory subTypeCategory, Double totalPrice) {
        setId(id);
        this.totalPrice = totalPrice;
        this.customerOrder = customerOrder ;
        this.idItem = idItem;
        this.orderItemTime = orderItemTime;
        this.amount = amount;
        this.price = price;
        this.subTypeCategory = subTypeCategory;
    }
}
