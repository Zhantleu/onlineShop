package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.buym.PropertyShaspay;
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
@Table(name = "shaspay")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Shaspay extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "shaspay", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyShaspay propertyShaspay;

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

    public PropertyShaspay getPropertyShaspay() {
        return propertyShaspay;
    }

    public void setPropertyShaspay(PropertyShaspay propertyShaspay) {
        this.propertyShaspay = propertyShaspay;
    }

}
