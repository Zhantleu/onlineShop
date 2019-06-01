package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.music.PropertyDabyl;
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
@Table(name = "dabyl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dabyl extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "dabyl", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyDabyl propertyDabyl;

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

    public PropertyDabyl getPropertyDabyl() {
        return propertyDabyl;
    }

    public void setPropertyDabyl(PropertyDabyl propertyDabyl) {
        this.propertyDabyl = propertyDabyl;
    }
}
