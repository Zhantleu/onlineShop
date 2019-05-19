package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.ashekey_biym.Saqina;
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
@Table(name = "property_saqina")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertySaqina extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saqina_id")
    private Saqina saqina;

    private String length;

    public Saqina getSaqina() {
        return saqina;
    }

    public void setSaqina(Saqina saqina) {
        this.saqina = saqina;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
