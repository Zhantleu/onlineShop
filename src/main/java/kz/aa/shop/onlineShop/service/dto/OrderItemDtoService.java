package kz.aa.shop.onlineShop.service.dto;

import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemDtoService {
    List<OrderItemDto> findByOrder(CustomerOrder customerOrder);
}
