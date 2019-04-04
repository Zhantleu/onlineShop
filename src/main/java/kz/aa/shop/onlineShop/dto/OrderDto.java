package kz.aa.shop.onlineShop.dto;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode()
@Builder
public class OrderDto {
    private List<OrderItemDto> orderItemDtos;

    public OrderDto() {
    }

    public OrderDto(List<OrderItemDto> orderItemDtos) {
        this.orderItemDtos = orderItemDtos;
    }

    public List<OrderItemDto> getOrderItemDtos() {
        return orderItemDtos;
    }

    public void setOrderItemDtos(List<OrderItemDto> orderItemDtos) {
        this.orderItemDtos = orderItemDtos;
    }

    //    private Double pr
}
