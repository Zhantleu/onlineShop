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

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "property_cap")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyCap extends BaseEntity {
    private Double price;

    @Enumerated(EnumType.STRING)
    private MaterialEnum materialEnum;

    @Enumerated(EnumType.STRING)
    private ColorEnum colorEnum;

    @Enumerated(EnumType.STRING)
    private SizeEnum sizeEnum;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cap_id")
    private Cap cap;
}
