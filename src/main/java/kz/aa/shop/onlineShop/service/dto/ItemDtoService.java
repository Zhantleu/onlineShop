package kz.aa.shop.onlineShop.service.dto;

import kz.aa.shop.onlineShop.dto.ItemDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemDtoService {
    List<ItemDto> findNewItemByTypeCategory(Class clazz);
    void findByIdAndCategory(List<OrderItemDto> orderItemDtos);
}
