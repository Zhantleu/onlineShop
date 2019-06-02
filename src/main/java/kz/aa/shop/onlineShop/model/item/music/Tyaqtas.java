package kz.aa.shop.onlineShop.model.item.music;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.PropertyTyaqtas;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "tyaqtas")
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tyaqtas extends BaseEntity {
    private String name;

    private Double price;


    @OneToOne(mappedBy = "tyaqtas", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyTyaqtas propertyTyaqtas;
    private Boolean isUsed = true;
}
