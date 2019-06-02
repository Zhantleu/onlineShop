package kz.aa.shop.onlineShop.repository.music;

import kz.aa.shop.onlineShop.model.item.music.Dombra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DombraRepository extends JpaRepository<Dombra, Long> {
    Page<Dombra> findAllByIsUsedTrue(Pageable pageable);
}
