package kz.aa.shop.onlineShop.repository.music;

import kz.aa.shop.onlineShop.model.item.music.Dombra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DombraRepository extends JpaRepository<Dombra, Long> {
}
