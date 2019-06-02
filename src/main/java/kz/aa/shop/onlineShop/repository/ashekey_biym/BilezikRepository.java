package kz.aa.shop.onlineShop.repository.ashekey_biym;

import kz.aa.shop.onlineShop.model.item.ashekey_biym.Bilezik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilezikRepository extends JpaRepository<Bilezik, Long> {
    Page<Bilezik> findAllByIsUsedTrue(Pageable pageable);
}
