package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.Cap;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="property_cap")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyCap extends BaseEntity {
    private Double price;

    @Enumerated(EnumType.STRING)
    private MaterialEnum materialEnum;

    @Enumerated(EnumType.STRING)
    private ColorEnum colorEnum;

    @ElementCollection(targetClass = Gender.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "item_size", joinColumns = @JoinColumn(name = "cap_property_id"))
    @Enumerated(EnumType.STRING)
    private Set<SizeEnum> sizeEnum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cap_id")
    private Cap cap;
}
