package kz.aa.shop.onlineShop.model.base;

import kz.aa.shop.onlineShop.model.property.enumeration.SubTypeCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseItemEntity extends BaseEntity implements Serializable{
    @NotBlank(message = "Пожалуйста загрузите фотографию")
    private String urlImage;

    @Enumerated(EnumType.STRING)
    private SubTypeCategory subTypeCategory;

    private String articul;
}
