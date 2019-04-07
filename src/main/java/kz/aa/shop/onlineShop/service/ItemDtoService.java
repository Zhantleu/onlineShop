package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.dto.ItemDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemDtoService {
    List<ItemDto> findNewItemByTypeCategory(Class clazz);
    void findByIdAndCategory(List<OrderItemDto> orderItemDtos);
}
