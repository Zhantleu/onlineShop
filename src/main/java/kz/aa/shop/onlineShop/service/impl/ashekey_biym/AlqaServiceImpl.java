package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Alqa;
import kz.aa.shop.onlineShop.repository.ashekey_biym.AlqaRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.AlqaService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AlqaServiceImpl extends BaseServiceImpl<Alqa, Long>  implements AlqaService {
    @Autowired
    private AlqaRepository alqaRepository;

    @Override
    public Page<Alqa> findAllByIsUsedTrue(Pageable pageable) {
        return alqaRepository.findAllByIsUsedTrue(pageable);
    }
}
