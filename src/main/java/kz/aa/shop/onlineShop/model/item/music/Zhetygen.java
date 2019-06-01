package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.music.PropertyZhetygen;
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
@Table(name = "zhetygen")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Zhetygen extends BaseItemEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "zhetygen", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyZhetygen propertyZhetygen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PropertyZhetygen getPropertyZhetygen() {
        return propertyZhetygen;
    }

    public void setPropertyZhetygen(PropertyZhetygen propertyZhetygen) {
        this.propertyZhetygen = propertyZhetygen;
    }
}
