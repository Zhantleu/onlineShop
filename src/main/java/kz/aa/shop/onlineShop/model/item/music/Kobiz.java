package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.music.PropertyKobiz;
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
@Table(name = "kobiz")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Kobiz extends BaseItemEntity{
    private String name;

    private Double price;


    @OneToOne(mappedBy = "kobiz", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyKobiz propertyKobiz;

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

    public PropertyKobiz getPropertyKobiz() {
        return propertyKobiz;
    }

    public void setPropertyKobiz(PropertyKobiz propertyKobiz) {
        this.propertyKobiz = propertyKobiz;
    }
}
