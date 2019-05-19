package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.clothes.Komzol;
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
@Table(name = "property_komzol")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyKomzol extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "komzol_id")
    private Komzol komzol;

    private String length;

    public Komzol getKomzol() {
        return komzol;
    }

    public void setKomzol(Komzol komzol) {
        this.komzol = komzol;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

}
