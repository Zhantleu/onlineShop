package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.model.property.enumeration.TypeCategory;
import kz.aa.shop.onlineShop.service.*;
import kz.aa.shop.onlineShop.util.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UtilController {
    private final OrderService orderService;
    private final UserService userService;
    private final DombraService dombraService;
    private final CapService capService;
    private final OrderItemService orderItemService;

    @Autowired
    public UtilController(OrderService orderService, UserService userService, DombraService dombraService, CapService capService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.userService = userService;
        this.dombraService = dombraService;
        this.capService = capService;
        this.orderItemService = orderItemService;
    }

    @PostMapping(value="addItem",produces="application/json")
    public @ResponseBody
    ValidationResponse addItem(@RequestParam(name = "itemId") Long itemId,
                          @RequestParam(name = "categoryType") String typeCategory) {

        Optional<User> user = userService.findCurrentUser();

        TypeCategory category = TypeCategory.valueOf(typeCategory);
        Order order = orderService.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user.get());
        OrderItem orderItem = new OrderItem();

        if (order == null)
            order = new Order(user.get(), false);

        orderService.saveOrUpdate(order);
        orderItem.setOrder(order);

        switch (category) {
            case CAP:
                setOrderItem(orderItem, capService.findById(itemId),TypeCategory.CAP);
                break;
            case DOMBRA:
                setOrderItem(orderItem, dombraService.findById(itemId), TypeCategory.DOMBRA);
                break;
        }

        return new ValidationResponse();
    }

    private void setOrderItem(OrderItem orderItem, BaseEntity baseEntity, TypeCategory typeCategory) {
        orderItem.setTypeCategory(typeCategory);
        orderItem.setIdItem(baseEntity.getId());
        orderItemService.saveOrUpdate(orderItem);
    }
}
