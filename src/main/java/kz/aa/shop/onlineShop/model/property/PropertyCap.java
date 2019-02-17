package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

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
}
