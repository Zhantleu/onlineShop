package kz.aa.shop.onlineShop.dto;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode()
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private List<OrderItemDto> orderItemDtos;
    private Double totalPrice;
}
