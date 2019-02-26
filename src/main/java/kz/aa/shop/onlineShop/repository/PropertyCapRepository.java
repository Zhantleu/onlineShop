package kz.aa.shop.onlineShop.repository;

import kz.aa.shop.onlineShop.model.property.PropertyCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyCapRepository extends JpaRepository<PropertyCap, Long> {
}
