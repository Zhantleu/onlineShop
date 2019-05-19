package kz.aa.shop.onlineShop.service.impl.item;

import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import kz.aa.shop.onlineShop.service.CapService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CapServiceImpl extends BaseServiceImpl<Cap, Long> implements CapService {
}
