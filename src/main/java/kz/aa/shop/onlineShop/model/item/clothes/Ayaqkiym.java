package kz.aa.shop.onlineShop.model.item.clothes;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertyAyaqkiym;
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
@Table(name = "ayaqkiym")
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ayaqkiym extends BaseEntity {
    private String name;

    private Double price;

    private Boolean isUsed = true;

    @OneToOne(mappedBy = "ayaqkiym", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyAyaqkiym propertyAyaqkiym;
}
