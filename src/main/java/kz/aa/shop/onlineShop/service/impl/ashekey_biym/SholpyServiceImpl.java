package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Sholpy;
import kz.aa.shop.onlineShop.repository.ashekey_biym.SholpyRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.SholpyService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SholpyServiceImpl extends BaseServiceImpl<Sholpy, Long> implements SholpyService {
    @Autowired
    private SholpyRepository sholpyRepository;

    @Override
    public Page<Sholpy> findAllByIsUsedTrue(Pageable pageable) {
        return sholpyRepository.findAllByIsUsedTrue(pageable);
    }
}
