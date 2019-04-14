package kz.aa.shop.onlineShop.controller;

import kz.aa.shop.onlineShop.model.User;
import kz.aa.shop.onlineShop.model.base.BaseEntity;
import kz.aa.shop.onlineShop.model.order.CustomerOrder;
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
    private final CustomerOrderService customerOrderService;
    private final UserService userService;
    private final DombraService dombraService;
    private final CapService capService;
    private final OrderItemService orderItemService;
    private CustomerOrder customerOrder;

    @Autowired
    public UtilController(CustomerOrderService customerOrderService, UserService userService, DombraService dombraService, CapService capService, OrderItemService orderItemService) {
        this.customerOrderService = customerOrderService;
        this.userService = userService;
        this.dombraService = dombraService;
        this.capService = capService;
        this.orderItemService = orderItemService;
    }

    @PostMapping(value = "cartFunction", produces = "application/json")
    public @ResponseBody
    ValidationResponse cartFunction(@RequestParam(name = "action") String action,
                                    @RequestParam(name = "itemId") Long itemId,
                                    @RequestParam(name = "categoryType") String typeCategory) {

        Optional<User> user = userService.findCurrentUser();

        user.ifPresent(user1 -> customerOrder = customerOrderService.findTopByUserAndIsConfirmedIsFalseOrderByOrderTimeDesc(user1));

        switch (action) {
            case "LIKE":
                likeFunction(itemId, typeCategory, user);
                break;
            case "DISLIKE":
                dislikeAction(itemId, typeCategory);
                break;
        }

        return new ValidationResponse();
    }

    private void likeFunction(@RequestParam(name = "itemId") Long itemId, @RequestParam(name = "categoryType") String typeCategory, Optional<User> user) {
        OrderItem orderItem = new OrderItem();

        if (customerOrder == null) {
            customerOrder = new CustomerOrder(user.get(), false);
        }

        customerOrderService.saveOrUpdate(customerOrder);
        orderItem.setCustomerOrder(customerOrder);

        switch (TypeCategory.valueOf(typeCategory)) {
            case CAP:
                setOrderItem(orderItem, capService.findById(itemId), TypeCategory.CAP);
                break;
            case DOMBRA:
                setOrderItem(orderItem, dombraService.findById(itemId), TypeCategory.DOMBRA);
                break;
        }
    }

    private void dislikeAction(@RequestParam(name = "itemId") Long itemId, @RequestParam(name = "categoryType") String typeCategory) {

        switch (TypeCategory.valueOf(typeCategory)) {
            case CAP:
                System.out.println(orderItemService.findByTypeCategoryAndIdItemAndCustomerOrder(itemId, customerOrder));
                orderItemService.delete(orderItemService.findByTypeCategoryAndIdItemAndCustomerOrder(itemId, customerOrder));
                break;
            case DOMBRA:
                orderItemService.delete(orderItemService.findByTypeCategoryAndIdItemAndCustomerOrder(itemId, customerOrder));
                break;
        }
    }

    private void setOrderItem(OrderItem orderItem, BaseEntity baseEntity, TypeCategory typeCategory) {
        orderItem.setTypeCategory(typeCategory);
        orderItem.setIdItem(baseEntity.getId());
        orderItemService.saveOrUpdate(orderItem);
    }
}
