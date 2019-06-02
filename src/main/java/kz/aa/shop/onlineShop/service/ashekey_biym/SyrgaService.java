package kz.aa.shop.onlineShop.service.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Syrga;
import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SyrgaService extends BaseService<Syrga, Long> {
    Page<Syrga> findAllByIsUsedTrue(Pageable pageable);
}
