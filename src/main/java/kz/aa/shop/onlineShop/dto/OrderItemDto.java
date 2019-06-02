package kz.aa.shop.onlineShop.dto;

import kz.aa.shop.onlineShop.model.property.enumeration.SubTypeCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode()
@Builder
@AllArgsConstructor
public class OrderItemDto {
    private Long idOrderItem;
    private SubTypeCategory subTypeCategory;
    private Long id;
    private String urlImage;
    private String name;
    private Double price;
    private Double totalPrice;
    private Long amount;
    private String articul;

    public OrderItemDto() {
    }

    public OrderItemDto(Long id, SubTypeCategory subTypeCategory, Long amount, Long idOrderItem) {
        this.subTypeCategory = subTypeCategory;
        this.id = id;
        this.amount = amount;
        this.idOrderItem = idOrderItem;
    }

    public OrderItemDto(SubTypeCategory subTypeCategory, Long id, String urlImage, String name, Double price, String articul, Long amount, Long idOrderItem) {
        this.subTypeCategory = subTypeCategory;
        this.id = id;
        this.urlImage = urlImage;
        this.name = name;
        this.price = price;
        this.articul = articul;
        this.amount = amount;
        this.idOrderItem = idOrderItem;
    }

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public SubTypeCategory getSubTypeCategory() {
        return subTypeCategory;
    }

    public void setSubTypeCategory(SubTypeCategory subTypeCategory) {
        this.subTypeCategory = subTypeCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }
}
