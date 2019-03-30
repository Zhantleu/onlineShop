package kz.aa.shop.onlineShop.dto;

import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;

@Data
@EqualsAndHashCode()
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Class clazz;
    private TypeCategory typeCategory;
    private String clazzName;
    private Long id;
    private BaseEntity baseEntity;
    private String urlImage;
}
