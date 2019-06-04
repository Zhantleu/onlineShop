package kz.aa.shop.onlineShop.model.item.clothes;


import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.clothes.PropertyCap;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "caps")
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cap extends BaseItemEntity {

    @OneToOne(mappedBy = "cap", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyCap propertyCap;

    private Boolean isUsed = true;

    private String name;

    private Double price;
}
