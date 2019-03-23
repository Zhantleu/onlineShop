package kz.aa.shop.onlineShop.service;

import kz.aa.shop.onlineShop.model.item.Cap;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CapService extends BaseService<Cap,Long> {
    Page findAllByCategory(Class clazz);
}
