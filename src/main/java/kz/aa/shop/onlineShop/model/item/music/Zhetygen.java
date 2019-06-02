package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.music.PropertyZhetygen;
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
@Table(name = "zhetygen")
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Zhetygen extends BaseItemEntity {
    private String name;

    private Double price;

    @OneToOne(mappedBy = "zhetygen", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyZhetygen propertyZhetygen;

    private Boolean isUsed = true;
}
