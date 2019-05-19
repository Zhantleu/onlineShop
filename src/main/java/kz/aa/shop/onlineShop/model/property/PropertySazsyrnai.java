package kz.aa.shop.onlineShop.model.property;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.music.Sazsyrnai;
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
@Table(name = "property_sazsyrnai")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertySazsyrnai extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sazsyrnai_id")
    private Sazsyrnai sazsyrnai;

    private String length;

    public Sazsyrnai getSazsyrnai() {
        return sazsyrnai;
    }

    public void setSazsyrnai(Sazsyrnai sazsyrnai) {
        this.sazsyrnai = sazsyrnai;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
