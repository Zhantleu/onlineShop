package kz.aa.shop.onlineShop.model.item;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.PropertyDombra;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "caps")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public @Data class Dombra extends BaseItemEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "dombra", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyDombra propertyDombra;
}
