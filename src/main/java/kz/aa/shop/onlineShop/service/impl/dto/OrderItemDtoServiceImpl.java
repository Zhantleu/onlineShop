package kz.aa.shop.onlineShop.service.impl.dto;

import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.OrderItemDtoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemDtoServiceImpl implements OrderItemDtoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderItemDto> findByOrder(CustomerOrder customerOrder) {
        String idParameter = "oi.idItem";
        String typeCategoryParameter = "oi.typeCategory";
        String amountParameter = "oi.amount";
        String idOrderItemParameter = "oi.id";

        Query query = entityManager.createQuery("SELECT " + idParameter + ", " + typeCategoryParameter + ", " + amountParameter + ", " + idOrderItemParameter +
                " from " + "OrderItem oi where oi.customerOrder = :customerOrder", Object[].class);
        query.setParameter("customerOrder", customerOrder);
        return parseOrderItemDto(query.getResultList());
    }

    private List<OrderItemDto> parseOrderItemDto(List<Object[]> resultList) {
        List<OrderItemDto> itemDtos = new ArrayList<>();

        for (Object[] objects : resultList) {
            itemDtos.add(new OrderItemDto((Long) objects[0],(TypeCategory) objects[1], (Long) objects[2], (Long) objects[3]));
        }

        return itemDtos;
    }
}
