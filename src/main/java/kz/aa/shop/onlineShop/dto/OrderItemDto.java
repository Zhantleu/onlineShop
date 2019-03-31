package kz.aa.shop.onlineShop.dto;

import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
@Builder
@AllArgsConstructor
public class OrderItemDto {
    private TypeCategory typeCategory;
    private Long id;
    private String urlImage;
    private String name;
    private Double price;
    private Double totalPrice;
    private Integer amount;
    private String articul;

    public OrderItemDto(Long id, TypeCategory typeCategory, Integer amount, Double totalPrice) {
        this.typeCategory = typeCategory;
        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public OrderItemDto(TypeCategory typeCategory, Long id, String urlImage, String name, Double price, String articul) {
        this.typeCategory = typeCategory;
        this.id = id;
        this.urlImage = urlImage;
        this.name = name;
        this.price = price;
        this.articul = articul;
    }
}
