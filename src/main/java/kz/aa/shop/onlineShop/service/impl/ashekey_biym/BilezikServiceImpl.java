package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Bilezik;
import kz.aa.shop.onlineShop.repository.ashekey_biym.BilezikRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.BilezikService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BilezikServiceImpl extends BaseServiceImpl<Bilezik, Long> implements BilezikService {
    @Autowired
    private BilezikRepository bilezikRepository;

    @Override
    public Page<Bilezik> findAllByIsUsedTrue(Pageable pageable) {
        return bilezikRepository.findAllByIsUsedTrue(pageable);
    }
}
