package kz.aa.shop.onlineShop.model.item.clothes;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertyKomzol;
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
@Table(name = "komzol")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Komzol extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "komzol", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyKomzol propertyKomzol;

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

    public PropertyKomzol getPropertyKomzol() {
        return propertyKomzol;
    }

    public void setPropertyKomzol(PropertyKomzol propertyKomzol) {
        this.propertyKomzol = propertyKomzol;
    }
}
