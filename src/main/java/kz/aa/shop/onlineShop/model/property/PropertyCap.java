package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.model.property.enumeration.ColorEnum;
import kz.aa.shop.onlineShop.model.property.enumeration.Gender;
import kz.aa.shop.onlineShop.model.property.enumeration.MaterialEnum;
import kz.aa.shop.onlineShop.model.property.enumeration.SizeEnum;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "property_cap")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyCap extends BaseEntity {

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

    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }

    public void setMaterialEnum(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    public SizeEnum getSizeEnum() {
        return sizeEnum;
    }

    public void setSizeEnum(SizeEnum sizeEnum) {
        this.sizeEnum = sizeEnum;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Cap getCap() {
        return cap;
    }

    public void setCap(Cap cap) {
        this.cap = cap;
    }
}
