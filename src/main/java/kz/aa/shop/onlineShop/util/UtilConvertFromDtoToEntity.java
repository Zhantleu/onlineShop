package kz.aa.shop.onlineShop.util;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilConvertFromDtoToEntity {

    public List<OrderItem> convertFromDtoToOrderItem(OrderDto orderDto) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDto orderItemDto : orderDto.getOrderItemDtos()) {
            orderItems.add(new OrderItem(orderDto.getCustomerOrder(),orderItemDto.getIdOrderItem(),orderItemDto.getId(), LocalDateTime.now(),orderItemDto.getAmount(),orderItemDto.getPrice(),orderItemDto.getSubTypeCategory(),orderItemDto.getTotalPrice()));
        }

        return orderItems;
    }

}
