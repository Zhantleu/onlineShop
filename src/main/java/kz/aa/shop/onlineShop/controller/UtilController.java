package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.TypeCategory;
import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.order.Order;
import kz.aa.shop.onlineShop.model.order.OrderItem;
import kz.aa.shop.onlineShop.service.CapService;
import kz.aa.shop.onlineShop.service.OrderItemService;
import kz.aa.shop.onlineShop.service.OrderService;
import kz.aa.shop.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class UtilController {
    private final OrderService orderService;
    private final UserService userService;
    private final CapService capService;
    private final OrderItemService orderItemService;

    @Autowired
    public UtilController(OrderService orderService, UserService userService, CapService capService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.userService = userService;
        this.capService = capService;
        this.orderItemService = orderItemService;
    }

    @RequestMapping(value = "/addItem",
            method = RequestMethod.POST)
    public String addItem(@RequestParam(name = "itemId") Long itemId,
                          @RequestParam(name = "categoryType") String typeCategory) {

        User user = userService.findCurrentUser();

        TypeCategory category = TypeCategory.valueOf(typeCategory);
        Order order = orderService.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user);
        OrderItem orderItem = new OrderItem();

        if (order == null)
            order = new Order(user, LocalDateTime.now(), false);

        orderService.saveOrUpdate(order);
        orderItem.setOrder(order);

        switch (category) {
            case CAP:
                setOrderItem(orderItem, capService.findById(itemId));
                break;
        }

        return "view/index";
    }

    private void setOrderItem(OrderItem orderItem, BaseEntity baseEntity) {
        orderItem.setTypeCategory(TypeCategory.CAP);
        orderItem.setIdItem(baseEntity.getId());
        orderItemService.saveOrUpdate(orderItem);
    }
}
