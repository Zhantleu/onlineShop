package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertySholpy;
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
@Table(name = "sholpy")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sholpy extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "sholpy", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySholpy propertySholpy;

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

    public PropertySholpy getPropertySholpy() {
        return propertySholpy;
    }

    public void setPropertySholpy(PropertySholpy propertySholpy) {
        this.propertySholpy = propertySholpy;
    }

}
