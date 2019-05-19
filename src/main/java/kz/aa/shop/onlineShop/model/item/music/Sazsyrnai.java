package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.PropertySazsyrnai;
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
@Table(name = "sazsyrnai")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sazsyrnai extends BaseItemEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "sazsyrnai", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertySazsyrnai propertySazsyrnai;

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

    public PropertySazsyrnai getPropertySazsyrnai() {
        return propertySazsyrnai;
    }

    public void setPropertySazsyrnai(PropertySazsyrnai propertySazsyrnai) {
        this.propertySazsyrnai = propertySazsyrnai;
    }
}
