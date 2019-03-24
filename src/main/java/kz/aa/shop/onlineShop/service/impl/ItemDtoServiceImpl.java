package kz.aa.shop.onlineShop.service.impl;

import kz.aa.shop.onlineShop.dto.ItemDto;
import kz.aa.shop.onlineShop.model.TypeCategory;
import kz.aa.shop.onlineShop.service.ItemDtoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemDtoServiceImpl implements ItemDtoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ItemDto> findNewItemByTypeCategory(Class clazz) {
        String tableName = clazz.getSimpleName();
        String idParameter = "f.id";
        String imgUrlParameter = "f.urlImage";

        Query query = entityManager.createQuery("SELECT " + idParameter + ", " + imgUrlParameter + " from "
                + tableName + " f", Object[].class);
//        query.setParameter("medicalCardId", medicalCardId);
        return parseBooleanWrapDto(query.getResultList(), clazz);
    }

    private List<ItemDto> parseBooleanWrapDto(List<Object[]> resultList, Class clazz) {
        List<ItemDto> itemDtos = new ArrayList<>();

        for (Object[] objects : resultList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setClazz(clazz);
            itemDto.setId((Long) objects[0]);
            itemDto.setClazzName(clazz.getSimpleName());
            itemDto.setUrlImage((String) objects[1]);
            itemDto.setTypeCategory(TypeCategory.valueOf(clazz.getSimpleName().toUpperCase()));

            itemDtos.add(itemDto);
        }

        return itemDtos;
    }
}
