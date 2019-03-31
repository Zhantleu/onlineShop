package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDtoService {
    OrderDto findItemOfOrder(List<OrderItemDto> itemDtoList);
}
