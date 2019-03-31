package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemDtoService {
    List<ItemDto> findNewItemByTypeCategory(Class clazz);
}
