package kz.aa.shop.onlineShop.dto;

import kz.aa.shop.onlineShop.model.property.enumeration.SubTypeCategory;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import lombok.*;

@Data
@EqualsAndHashCode()
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Class clazz;
    private SubTypeCategory subTypeCategory;
    private String clazzName;
    private Long id;
    private BaseEntity baseEntity;
    private String urlImage;
}
