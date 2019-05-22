package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Shaspay;
import kz.aa.shop.onlineShop.service.ashekey_biym.ShaspayService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShaspayServiceImpl extends BaseServiceImpl<Shaspay, Long> implements ShaspayService {
}
