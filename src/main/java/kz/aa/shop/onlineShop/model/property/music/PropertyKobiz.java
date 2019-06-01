package kz.aa.shop.onlineShop.model.property.music;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.music.Kobiz;
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
@Table(name = "property_kobiz")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyKobiz extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kobiz_id")
    private Kobiz kobiz;

    private String length;

    public Kobiz getKobiz() {
        return kobiz;
    }

    public void setKobiz(Kobiz kobiz) {
        this.kobiz = kobiz;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
