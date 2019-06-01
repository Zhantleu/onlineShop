package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.buym.PropertyAlqa;
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
@Table(name = "alqa")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alqa extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "alqa", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyAlqa propertyAlqa;

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

    public PropertyAlqa getPropertyAlqa() {
        return propertyAlqa;
    }

    public void setPropertyAlqa(PropertyAlqa propertyAlqa) {
        this.propertyAlqa = propertyAlqa;
    }

}
