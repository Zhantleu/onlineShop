package kz.aa.shop.onlineShop.service.music;

import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DombraService extends BaseService<Dombra,Long> {
    Page<Dombra> findAllByIsUsedTrue(Pageable pageable);
}
