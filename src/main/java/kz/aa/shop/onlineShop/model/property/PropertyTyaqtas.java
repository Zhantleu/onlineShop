package kz.aa.shop.onlineShop.model.property;

import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.item.music.Tyaqtas;
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
@Table(name = "property_tyaqtas")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PropertyTyaqtas extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tyaqtas_id")
    private Tyaqtas tyaqtas;

    private String length;

    public Tyaqtas getTyaqtas() {
        return tyaqtas;
    }

    public void setTyaqtas(Tyaqtas tyaqtas) {
        this.tyaqtas = tyaqtas;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
