package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.buym.PropertySyrga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "syrga")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Syrga extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "syrga", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySyrga propertySyrga;

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

    public PropertySyrga getPropertySyrga() {
        return propertySyrga;
    }

    public void setPropertySyrga(PropertySyrga propertySyrga) {
        this.propertySyrga = propertySyrga;
    }
}
