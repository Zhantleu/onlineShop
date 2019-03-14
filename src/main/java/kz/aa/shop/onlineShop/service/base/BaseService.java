package kz.aa.shop.onlineShop.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService <T, I> {

    //    @CacheEvict(value = "serviceCache", allEntries = true)
    T saveOrUpdate(T entity);

    //    @Cacheable(value = "serviceCache")
    T findById (I id);

    //    @CacheEvict(value = "serviceCache")
    void delete(T id);

    //@Cacheable(value = "serviceCache")
    Page<T> findAll(Pageable pageable);

    List<T> findAll();

}