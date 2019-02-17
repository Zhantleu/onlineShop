package kz.aa.shop.onlineShop.model.item;


import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.property.Gender;
import kz.aa.shop.onlineShop.model.property.PropertyCap;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "caps")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cap extends BaseEntity {

    @ElementCollection(targetClass = Gender.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "item_gender", joinColumns = @JoinColumn(name = "cap_id"))
    @Enumerated(EnumType.STRING)
    private Set<Gender> genders;

    @OneToOne(mappedBy = "cap", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PropertyCap propertyCap;

    private String url;

    private String name;
}
