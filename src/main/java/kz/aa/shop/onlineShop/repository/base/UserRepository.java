package kz.aa.shop.onlineShop.repository.base;

import kz.aa.shop.onlineShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);

    Optional<User> findByEmail(String email);
}