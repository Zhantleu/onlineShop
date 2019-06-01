package kz.aa.shop.onlineShop.service.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Alqa;
import kz.aa.shop.onlineShop.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AlqaService extends BaseService<Alqa, Long> {
    Page<Alqa> findAllByIsUsedTrue(Pageable pageable);
}
