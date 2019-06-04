package kz.aa.shop.onlineShop.model.item.ashekey_biym;

import kz.aa.shop.onlineShop.model.base.BaseItemEntity;
import kz.aa.shop.onlineShop.model.property.buym.PropertyAlqa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "alqa")
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alqa extends BaseItemEntity {
    private String name;

    private Double price;

    private Boolean isUsed = true;

    @OneToOne(mappedBy = "alqa", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyAlqa propertyAlqa;

}
