package kz.aa.shop.onlineShop.repository.item;

import kz.aa.shop.onlineShop.model.item.Cap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapRepository extends JpaRepository<Cap, Long> {
}
