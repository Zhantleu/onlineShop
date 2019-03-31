package kz.aa.shop.onlineShop.service.impl.dto;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.OrderDtoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDtoServiceImpl implements OrderDtoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderDto findItemOfOrder(List<OrderItemDto> itemDtoList) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderItemDtos(new ArrayList<>());

        Query query;
        for (OrderItemDto orderItemDto : itemDtoList) {
            switch (orderItemDto.getTypeCategory()) {
                case CAP:
                    query = entityManager.createQuery("SELECT f.id,f.urlImage,f.name,f.price,f.articul from "
                            + "Cap f where f.id = :id", Object[].class);
                    query.setParameter("id",orderItemDto.getId());
                    parseOrderDto(query.getResultList(), TypeCategory.CAP, orderDto);
                    break;
                case DOMBRA:
                    query = entityManager.createQuery("SELECT f.id,f.urlImage,f.name,f.price,f.articul from "
                            + "Dombra f where f.id = :id", Object[].class);
                    query.setParameter("id",orderItemDto.getId());
                    parseOrderDto(query.getResultList(), TypeCategory.DOMBRA, orderDto);
                    break;
            }
        }

        return orderDto;
    }

    private void parseOrderDto(List<Object[]> resultList, TypeCategory typeCategory, OrderDto orderDto) {
            for (Object[] object : resultList) {
                orderDto.getOrderItemDtos().add(new OrderItemDto(typeCategory,(Long) object[0],(String) object[1],(String) object[2],
                        (Double) object[3],(String) object[4]));
            }
    }
}
