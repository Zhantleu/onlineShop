package kz.aa.shop.onlineShop.model.item.clothes;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertyAyaqkiym;
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
@Table(name = "ayaqkiym")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ayaqkiym extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "ayaqkiym", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyAyaqkiym propertyAyaqkiym;

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

    public PropertyAyaqkiym getPropertyAyaqkiym() {
        return propertyAyaqkiym;
    }

    public void setPropertyAyaqkiym(PropertyAyaqkiym propertyAyaqkiym) {
        this.propertyAyaqkiym = propertyAyaqkiym;
    }
}
