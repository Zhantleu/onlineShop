package kz.aa.shop.onlineShop.service.impl.item;

import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import kz.aa.shop.onlineShop.repository.clothes.CapRepository;
import kz.aa.shop.onlineShop.service.clothes.CapService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CapServiceImpl extends BaseServiceImpl<Cap, Long> implements CapService {

    @Autowired
    private CapRepository capRepository;

    @Override
    public Page<Cap> findAllByIsUsedTrue(Pageable pageable) {
        return capRepository.findAllByIsUsedTrue(pageable);
    }
}
