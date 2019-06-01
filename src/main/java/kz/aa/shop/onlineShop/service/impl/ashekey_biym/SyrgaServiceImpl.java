package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Syrga;
import kz.aa.shop.onlineShop.repository.ashekey_biym.SyrgaRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.SyrgaService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SyrgaServiceImpl extends BaseServiceImpl<Syrga, Long> implements SyrgaService {
    @Autowired
    private SyrgaRepository syrgaRepository;

    @Override
    public Page<Syrga> findAllByIsUsedTrue(Pageable pageable) {
        return syrgaRepository.findAllByIsUsedTrue(pageable);
    }
}
