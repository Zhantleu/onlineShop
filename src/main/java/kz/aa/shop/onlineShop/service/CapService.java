package kz.aa.shop.onlineShop.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CapService {
    Page findAllByCategory(Class clazz);
}
