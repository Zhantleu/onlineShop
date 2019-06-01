package kz.aa.shop.onlineShop.model.property.clothes;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.clothes.Ayaqkiym;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "property_ayaqkiym")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyAyaqkiym extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ayaqkiym_id")
    private Ayaqkiym ayaqkiym;

    private String length;

    public Ayaqkiym getAyaqkiym() {
        return ayaqkiym;
    }

    public void setAyaqkiym(Ayaqkiym ayaqkiym) {
        this.ayaqkiym = ayaqkiym;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
