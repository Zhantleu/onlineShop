package kz.aa.shop.onlineShop.model;

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
@Table(name = "order_items", schema = "public")
public class OrderItem extends BaseEntity {
    @OneToMany
    private Order order;

    private Long idItem;
    private TypeCategory typeCategory;
}
