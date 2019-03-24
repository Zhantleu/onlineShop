package kz.aa.shop.onlineShop.model.item;


import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.PropertyCap;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "caps")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cap extends BaseItemEntity {

    @OneToOne(mappedBy = "cap", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyCap propertyCap;

    private String name;

    private Double price;

    public PropertyCap getPropertyCap() {
        return propertyCap;
    }

    public void setPropertyCap(PropertyCap propertyCap) {
        this.propertyCap = propertyCap;
    }

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
}
