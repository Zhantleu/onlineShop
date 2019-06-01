package kz.aa.shop.onlineShop.model.property.buym;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.ashekey_biym.Sholpy;
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
@Table(name = "property_sholpy")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertySholpy extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sholpy_id")
    private Sholpy sholpy;

    private String length;

    public Sholpy getSholpy() {
        return sholpy;
    }

    public void setSholpy(Sholpy sholpy) {
        this.sholpy = sholpy;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
