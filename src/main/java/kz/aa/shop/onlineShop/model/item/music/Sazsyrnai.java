package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.PropertySazsyrnai;
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
@Table(name = "sazsyrnai")
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sazsyrnai extends BaseItemEntity {
    private String name;

    private Double price;

    private Boolean isUsed = true;
    @OneToOne(mappedBy = "sazsyrnai", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySazsyrnai propertySazsyrnai;
}
