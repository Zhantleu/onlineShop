package kz.aa.shop.onlineShop.dto;

import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode()
@Builder
public class OrderDto {
    private List<OrderItemDto> orderItemDtos;
    private CustomerOrder customerOrder;

    public OrderDto() {
    }

    public OrderDto(List<OrderItemDto> orderItemDtos, CustomerOrder customerOrder) {
        this.orderItemDtos = orderItemDtos;
        this.customerOrder = customerOrder;
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
}
