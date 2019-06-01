package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertySyrga;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "syrga")
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Syrga extends BaseEntity {
    private String name;

    private Double price;

    private Boolean isUsed = true;

    @OneToOne(mappedBy = "syrga", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySyrga propertySyrga;
}
