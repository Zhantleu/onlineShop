package kz.aa.shop.onlineShop.model.property.music;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.music.Zhetygen;
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
@Table(name = "property_zhetygen")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyZhetygen extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zhetygen_id")
    private Zhetygen zhetygen;

    private String length;

    public Zhetygen getZhetygen() {
        return zhetygen;
    }

    public void setZhetygen(Zhetygen zhetygen) {
        this.zhetygen = zhetygen;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
