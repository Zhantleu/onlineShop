package kz.aa.shop.onlineShop.service.base;

import java.util.List;

public interface BaseService <T, I> {

    //    @CacheEvict(value = "serviceCache", allEntries = true)
    T saveOrUpdate(T entity);

    //    @Cacheable(value = "serviceCache")
    T findById (I id);

    //    @CacheEvict(value = "serviceCache")
    void delete(T id);

    //@Cacheable(value = "serviceCache")
    List<T> findAll();

}