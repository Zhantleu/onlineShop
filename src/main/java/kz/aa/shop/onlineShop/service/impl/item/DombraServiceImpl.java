package kz.aa.shop.onlineShop.service.impl.item;

import kz.aa.shop.onlineShop.model.item.Dombra;
import kz.aa.shop.onlineShop.service.DombraService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DombraServiceImpl extends BaseServiceImpl<Dombra, Long> implements DombraService {
}
