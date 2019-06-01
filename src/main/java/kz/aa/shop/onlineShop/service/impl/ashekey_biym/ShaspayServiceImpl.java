package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Shaspay;
import kz.aa.shop.onlineShop.repository.ashekey_biym.ShaspayRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.ShaspayService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ShaspayServiceImpl extends BaseServiceImpl<Shaspay, Long> implements ShaspayService {
    @Autowired
    private ShaspayRepository shaspayRepository;

    @Override
    public Page<Shaspay> findAllByIsUsedTrue(Pageable pageable) {
        return shaspayRepository.findAllByIsUsedTrue(pageable);
    }
}
