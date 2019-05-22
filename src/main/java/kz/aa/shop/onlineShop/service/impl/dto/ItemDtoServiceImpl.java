package kz.aa.shop.onlineShop.service.impl.dto;

import kz.aa.shop.onlineShop.dto.ItemDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.dto.ItemDtoService;
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
        return parseItemDto(query.getResultList(), clazz);
    }

//    todo
    @Override
    public void findByIdAndCategory(List<OrderItemDto> orderItemDtos) {
        Query query;

        for (OrderItemDto orderItemDto : orderItemDtos) {
            switch (orderItemDto.getTypeCategory()) {
                case CAP:
                    query = entityManager.createQuery("SELECT oi.price from " + "Cap oi where oi.id = :id", Object[].class);
                    query.setParameter("id", orderItemDto.getId());
                    orderItemDto.setPrice((Double) query.getResultList().get(0));
                    break;
                case DOMBRA:
                    query = entityManager.createQuery("SELECT oi.price from " + "Dombra oi where oi.id = :id", Object[].class);
                    query.setParameter("id", orderItemDto.getId());
                    orderItemDto.setPrice((Double) query.getResultList().get(0));
                    break;
            }
        }
    }


    private List<ItemDto> parseItemDto(List<Object[]> resultList, Class clazz) {
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
