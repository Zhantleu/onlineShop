package kz.aa.shop.onlineShop.service.impl.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Saqina;
import kz.aa.shop.onlineShop.repository.ashekey_biym.SaqinaRepository;
import kz.aa.shop.onlineShop.service.ashekey_biym.SaqinaService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SaqinaServiceImpl extends BaseServiceImpl<Saqina, Long> implements SaqinaService {
    @Autowired
    private SaqinaRepository saqinaRepository;

    @Override
    public Page<Saqina> findAllByIsUsedTrue(Pageable pageable) {
        return saqinaRepository.findAllByIsUsedTrue(pageable);
    }
}
