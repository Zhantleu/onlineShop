package kz.aa.shop.onlineShop.service.clothes;

import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CapService extends BaseService<Cap,Long> {
    Page<Cap> findAllByIsUsedTrue(Pageable pageable);
}
