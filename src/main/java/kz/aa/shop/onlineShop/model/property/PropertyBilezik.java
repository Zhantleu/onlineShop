package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.ashekey_biym.Bilezik;
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
@Table(name = "property_bilezik")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyBilezik extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bilezik_id")
    private Bilezik bilezik;

    private String length;

    public Bilezik getBilezik() {
        return bilezik;
    }

    public void setBilezik(Bilezik bilezik) {
        this.bilezik = bilezik;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
