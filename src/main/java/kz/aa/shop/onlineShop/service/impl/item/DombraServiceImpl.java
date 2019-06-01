package kz.aa.shop.onlineShop.service.impl.item;

import kz.aa.shop.onlineShop.model.item.music.Dombra;
import kz.aa.shop.onlineShop.repository.music.DombraRepository;
import kz.aa.shop.onlineShop.service.music.DombraService;
import kz.aa.shop.onlineShop.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DombraServiceImpl extends BaseServiceImpl<Dombra, Long> implements DombraService {
    @Autowired
    private DombraRepository dombraRepository;


    @Override
    public Page<Dombra> findAllByIsUsedTrue(Pageable pageable) {
        return dombraRepository.findAllByIsUsedTrue(pageable);
    }
}
