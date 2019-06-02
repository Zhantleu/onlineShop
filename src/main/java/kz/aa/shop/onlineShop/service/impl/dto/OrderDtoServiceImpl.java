package kz.aa.shop.onlineShop.service.impl.dto;

import kz.aa.shop.onlineShop.dto.OrderDto;
import kz.aa.shop.onlineShop.dto.OrderItemDto;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
import kz.aa.shop.onlineShop.model.property.enumeration.SubTypeCategory;
import kz.aa.shop.onlineShop.service.dto.OrderDtoService;
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
    public OrderDto findItemOfOrder(List<OrderItemDto> itemDtoList, CustomerOrder customerOrder) {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerOrder(customerOrder);
        orderDto.setOrderItemDtos(new ArrayList<>());

        for (OrderItemDto orderItemDto : itemDtoList) {
            switch (orderItemDto.getSubTypeCategory()) {
                case CAP:
                    parseOrderDto(returnResultList(orderItemDto), SubTypeCategory.CAP, orderDto, orderItemDto.getIdOrderItem(), orderItemDto.getAmount());
                    break;
                case DOMBRA:
                    parseOrderDto(returnResultList(orderItemDto), SubTypeCategory.DOMBRA, orderDto, orderItemDto.getIdOrderItem(), orderItemDto.getAmount());
                    break;
            }
        }

        return orderDto;
    }

    private void parseOrderDto(List<Object[]> resultList, SubTypeCategory subTypeCategory, OrderDto orderDto, Long idOrderItem, Long amount) {
        for (Object[] object : resultList) {
            orderDto.getOrderItemDtos().add(new OrderItemDto(subTypeCategory, (Long) object[0], (String) object[1], (String) object[2],
                    (Double) object[3], (String) object[4], amount, idOrderItem));
        }
    }

    private List<Object[]> returnResultList(OrderItemDto orderItemDto) {
        Query query;
        switch (orderItemDto.getSubTypeCategory()) {
            case CAP:
                query = entityManager.createQuery("SELECT f.id,f.urlImage,f.name,f.price,f.articul from "
                        + "Cap f where f.id = :id", Object[].class);
                query.setParameter("id", orderItemDto.getId());
                return query.getResultList();
            case DOMBRA:
                query = entityManager.createQuery("SELECT f.id,f.urlImage,f.name,f.price,f.articul from "
                        + "Dombra f where f.id = :id", Object[].class);
                query.setParameter("id", orderItemDto.getId());
                return query.getResultList();
            default:
                return null;
        }
    }
}
