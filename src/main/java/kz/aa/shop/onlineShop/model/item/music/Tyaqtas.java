package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.music.PropertyTyaqtas;
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
@Table(name = "tyaqtas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tyaqtas extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "tyaqtas", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyTyaqtas propertyTyaqtas;

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

    public PropertyTyaqtas getPropertyTyaqtas() {
        return propertyTyaqtas;
    }

    public void setPropertyTyaqtas(PropertyTyaqtas propertyTyaqtas) {
        this.propertyTyaqtas = propertyTyaqtas;
    }
}
