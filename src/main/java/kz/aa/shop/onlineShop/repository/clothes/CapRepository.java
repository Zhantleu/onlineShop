package kz.aa.shop.onlineShop.repository.clothes;

import kz.aa.shop.onlineShop.model.item.clothes.Cap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapRepository extends JpaRepository<Cap, Long> {
    Page<Cap> findAllByIsUsedTrue(Pageable pageable);
}
