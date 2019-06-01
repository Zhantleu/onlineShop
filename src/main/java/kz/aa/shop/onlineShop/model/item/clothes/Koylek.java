package kz.aa.shop.onlineShop.model.item.clothes;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.clothes.PropertyKoylek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "koylek")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Koylek extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "koylek", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyKoylek propertyKoylek;

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

    public PropertyKoylek getPropertyKoylek() {
        return propertyKoylek;
    }

    public void setPropertyKoylek(PropertyKoylek propertyKoylek) {
        this.propertyKoylek = propertyKoylek;
    }
}
